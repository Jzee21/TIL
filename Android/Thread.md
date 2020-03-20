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







