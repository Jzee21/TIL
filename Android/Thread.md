# Thread

> Application 작동 중에 AND(Application Not Responding) 를 피하기 위해서
>
> 작업시간이 오래 걸리는 Logic 처리는 Thread를 이용하여 별도의 작업분기를 통해 처리한다
>
> [Java Thread](https://github.com/Jzee21/TIL/blob/master/Java/Thread.md)

> 공통예제 - 1~10,000,000,000 까지의 합을 구한다
>
> Activity는 공통적으로
>
> - 연산 결과를 가질 TextView
> - 연산을 시작하는 Button
> - Toast 메세지를 출력해 AND 상태인지 확인하기 위한 Button
>
> 을 갖는다
>
> ```xml
> <LinearLayout>
> 	<TextView
> 		android:id="@+id/sumtv"/>
>     <Button
>         android:id="@+id/startBtn"/>
>     <Button
>         android:id="@+id/startBtn"/>
> </LinearLayout>
> ```
>
> 

## Thread 사용

- Activity 내부에 연산을 처리할 수 있도록

  Runnable 객체를 inner class로 생성한다

```java
// Inner Class for Thread
class MyRunnable implements Runnable {
    @Override
    public void run() {
        long sum = 0;
        for (long i=0 ; i<10000000000L ; i++) {
            sum += i;
        }
        Log.i("SumTest", "총 합은 : " + sum);
    }
}
```

- Button을 누를 때 연산이 시작되도록 Listener 내부에서 Thread를 실행한다

```java
Button startBtn = (Button) findViewById(R.id.startBtn);
startBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Thread를 만들어서 실행
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
});
```



## Widget 접근

> Thread 의 동작상태를 확인하기 위해
>
> `ProgressBar`를 이용하여 연산의 진행상태를 Activity에서 확인한다

- 위의 Runnable 객체가 일부 변경된다.

```java
private TextView tv;
private ProgressBar pb;

// .....

// Inner Class for Thread
class MyRunnable implements Runnable {
    @Override
    public void run() {
        long sum = 0;
        for (long i=0 ; i<10000000000L ; i++) {
            sum += i;
            if (i % 100000000 == 9) {
                int loop = (int) i/100000000;
                // ProgressBar의 진행률 설정
                pb.setProgress(loop);
            }
        }
        // TextView에 연산결과 표시
        tv.setText("연산결과 : " + sum);
    }
}
```



### 주의

> 위의 예제에서는 Thread 내부에서 View Component를 직접 접근하여 설정하고 있다.
>
> 코드는 작동하지만, 이는 올바른 방법이 아니다.
>
> 그 이유로
>
> 1. Android의 UI Component(Widget)은 Thread Safe 하지 않다
>
>    - 즉, 하나의 Thread가 UI Component에 접근할 때,
>
>      다른 Thread의 접근 권한이 Rock되지 않아
>
>      의도치 않은 화면제어가 발생할 수 있다.
>
> 2. Android UI component의 화면제어는
>
>    오직 UI Thread(Activity)에 의해서만 제어되어야 한다
>
> 의 규칙을 갖는다. 즉,
>
> ```java
> /*
> 	UI Thread가 아닌 외부 Thread에서
> 		UI Componrnt를 직접 제어할 수 없다. (해서는 안된다)
> */
> ```

> 따라서, Thread의 로직 처리에 따른 UI Component의 화면제어를 하기 위해서는
>
> 다른 방법을 사용해야 한다.
>
> 그 방법 중 하나로 `Handler`를 사용하는 방법이 있다.



## Widget 접근 (Handler)

> Thread와 Activity 사이에서 Data를 주고받기 위해서
>
> Thread 와 Activity는 하나의 `Handler` 객체를 같이 사용한다.

### Handler 생성

1. 기본 방법

   ```java
   Handler handler = new Handler()
   ```

    

2. Handler를 생성할 때, 필요한 메서드를 Override 하여 생성할 수 있다.

   > `handleMessage()` 메서드를 이용해 Thread로부터 데이터를 받을 수 있다.

   ```java
   @SuppressLint("HandlerLeak")      // Memory Leak 방지 @
   final Handler handler = new Handler() {
       
       @Override
       // 메세지를 받을 때 실행 - 화면 처리
       public void handleMessage(@NonNull Message msg) {
           super.handleMessage(msg);
   
           String count = msg.getData().getString("count");
           pb.setProgress(Integer.parseInt(count));
       }
       
   };
   ```

   - 일부 메서드만 Override 할 때, Momory Leak 에러가 발생할 수 있다.

     이때, 메서드 앞에 `@SuppressLint("HandlerLeak")`를 추가해

     Memory Leak를 방지한다.



### Handler를 가진 Thread 생성

> 버튼을 클릭했을 때, 연산을 담당하는 Thread가 생성되는 프로그램이다

- Button Click Listener

  ```java
  Button startBtn = (Button) findViewById(R.id.startBtn);
  startBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          // Runnable 객체 생성
          MySumThread runnable = new MySumThread(handler);
          Thread t = new Thread(runnable);
          t.start();
      }
  });
  ```

  - `Runnable` 객체를 생성할 때, `Handler` 객체를 매개변수로 넘겨준다.

- Runnable Class

  ```java
  class MySumThread implements Runnable {
  
      private Handler handler;
  
      // Handler를 매개변수로 갖는 생성자
      MySumThread(Handler handler) {
          this.handler = handler;
      }
  
      @Override
      public void run() {
          long sum = 0;
          for (long i=0 ; i<1000000000L ; i++) {
              sum += i;
              if(i % 1000000 == 0) {
                  int loop = (int) i/10000000;
                  // Message를 만들어
                  // Handler를 이용해 Activity에게 전달
                  // 데이터를 갖는 Bundle 객체 생성
                  Bundle bundle = new Bundle();
                  bundle.putString(
                      "count", String.valueOf(loop));
                  // Bundle을 담을 Message 객체 생성
                  Message msg = new Message();
                  msg.setData(bundle);
                  // Handler.sendMessage()
                  this.handler.sendMessage(msg);
              }
          }
      }
      
  }
  ```

  - `Runnable` 객체가 생성될 때 `Handler` 객체를 받기 위해

    매개변수를 갖는 생성자를 생성한다.

  - `sendMessage()` 메서드를 이용해 Activity에게 데이터를 전달할 수 있다.

  - `sendMessage()` 메서드는 `Message` 객체를 매개변수로 갖는다

  - `Message` 객체는 `Bundle` 객체를 이용해 데이터를 담는다

  - `Bundle` 객체는 `putString()` 메서드를 이용해 데이터를 담는다

    - `putString()` 메서드는 

      `String` 형태의 Key와 Value의 매개변수를 갖는다.

  - 즉, 

    ```java
    Handler.sendMessage(
        Message.setDate(
        	Bundle.putString(String key, String value)
        )
    )
    ```

    의 형태로 데이터를 전송한다. (ah.....)



