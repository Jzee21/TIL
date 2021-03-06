# Event

---

## Event란?

> Event  -  사용자 혹은 시스템에 의해서 발생되는 모든 것



---

## Event 처리

### Event Handling 

>  Java  -  `Event Delegation Model`을 이용해 Event 처리



### Event 처리 객체

> Event의 처리와 관련된 객체 3가지를 소개한다.

1. Event Source
   - Event가 발생한 객체를 지칭
2. Event Handler (Listener)
   - Event를 처리하는 객체
3. Event
   - 발생된 Event에 대한 세부정보를 가진 객체

- Event Source는 이미 생성됨, Event 객체는 자동적으로 생성

  Event Source에 Event Handler를 부착시켜

  Event가 발생되면 부착된 Handler를 통해 Event를 처리한다

  

#### 1. Event Source 생성

1. Button에 ID지정

   - Avtivity의 xml 파일에서 해당 Component에 id를 지정한다.

   - ```xml
     android:id="@+id/eventBtn"
     ```

   - `"@+id/{_ID_}"`를 이용하여 `id의 목록`에 `__ID__`를 추가한다.

   

2. Activity에서 ID를 이용해 객체 생성

   - Java에서 Component들은 `android.widget` 패키지에 속한다.
     - 예 ) `android.widget.Button`
   - `findViewById()`를 이용해 component를 찾아 지정한다.
     - id의 목록은 `R.id`를 이용해 접근한다.
     - `findViewById()`의 return값은 Object객체이다.

   ```java
   Button myBtn = (Button) findViewById(R.id.eventBtn);
   TextView tv = (TextView) findViewById(R.id.myTv);
   ```



#### 2. Event Handler (Other Class) 생성

> Handler 기능만을 위한 별도의 외부 클래스를 사용하는 방법

```java
public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ....
        // Handler class 생성
        MyEventHandler handler = new MyEventHandler(tv);
        // ....
    }
}

class MyEventHandler implements View.OnClickListener {

    private TextView tv;

    MyEventHandler() {  }
    MyEventHandler(TextView tv) {
        this.tv = tv;
    }

    @Override
    public void onClick(View v) {
        // Event 처리 코드
        // Log.i("MyEvent", "버튼이 눌렸다");
        tv.setText("Clicked");
    }
}
```

- 일반적인 객체가 아닌, 

  Event를 처리할 수 있는 interface를 상속한 Listener 객체가 필요

  - `View.OnClickListener` interface를 상속한다

  - `implements View.OnClickListener`

- interface의 추상메서드 `onClick()`을 Override 한다.

- interface는 Event의 종류에 따라 다양하게 존재한다.



#### 3. Event Source에 Event Handler 연결

```java
public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// .....
        myBtn.setOnClickListener(handler);
    }
}
```





#### 4. anonymous inner class

> **실제 구현에서는 anonymous inner class(익명 이너클래스)를 이용하기 때문에**
>
> **위와 같은 외부 class는 사용하지 않는다.**

```java
public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // 1. Event Source instance
        Button myBtn = (Button) findViewById(R.id.eventBtn);
        final TextView tv = (TextView) findViewById(R.id.myTv);
        // 상수화 시켜 heap 영역에 존재하도록 하여
        // onCreate()가 종료되어도 변수가 존재하도록 한다.(생존시간 증가)

        // 2+3. Event Source에 Event Handler 객체를 생성헤서 부착
        // anonymous inner class
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Clicked");
            }
        });
    }
}
```





## Click Event

> `View.OnClickListener()`
>
> Button의 onClick() method를 이용해 Image View의 이미지를 변경한다.

- xml을 이용해 component들을 지정

  ```xml
  <ImageView
  	android:id="@+id/iv"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:adjustViewBounds="true"
      android:scaleType="fitCenter"
      android:src="@drawable/yuna"/>
  
  <Button
      android:id="@+id/imageChangeBtn"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="이미지 변경"/>
  ```

  - id를 반드시 지정해두자

  

- id를 이용한 component의 instance화

  ```java
  public class Example03_EventActivity .... {
      private ImageView iv;
      
      protected void onCreate(Bundle savedInstanceState) {
          iv = (ImageView) findViewById(R.id.iv);
          Button btn = 
              (Button) findViewById(R.id.imageChangeBtn);
      }
  }
  ```

  

- Button을 Click 했을 때 작동하도록 Handler 생성, 부착

  ```java
  btn.setOnClickListener(new View.OnClickListener() {
  	@Override
      public void onClick(View v) {
          // Image View에 표시될 file의 id 지정
      	iv.setImageResource(R.drawable.iu_love_poem);
      }
  });
  ```

  



## Touch Event

> `onTouchEvent()` 또는 `View.OnTouchListener()`

### Touch Event

> Activity에서 제공하는 `onTouchEvent(MotionEvent event)`를 이용하여 Touch Event를 처리한다
>
> 화면을 터치했을 때, Toast 메세지를 출력한다.

- Activity에서 Touch Event를 인식할 수 있도록

  `onTouchEvent()를 Override` 한다.

  ```java
  public class Example04 extends AppCompatActivity {
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          // ...
      }
  
      @Override
      public boolean onTouchEvent(MotionEvent event) {
          // ...
          return super.onTouchEvent(event);
      }
  
  }
  ```

  > Touch Event는 화면에 손이 닿을때, 떨어질때 모두 발생한다

- Toast Message를 사용하기 위해 makeText()를 사용한다.

  ```java
  @Override
      public boolean onTouchEvent(MotionEvent event) {
          // Toast Event
          Toast.makeText(this, 
                         "message", 
                         Toast.LENGTH_SHORT).show();
  
          return super.onTouchEvent(event);
      }
  ```

  - Toast.makeText(...).show()

    - Toast.makeText()를 이용해 Toast Message를 생성하고

      show() method를 이용해 화면에 표시한다

  - Toast.makeText(Context, text, duration)

    - Context  (Interface)

      Activity는 Context를 상속하기 때문에

      현재 Activity에 Toast 메세지를 띄우기 위해 this를 사용할 수 있다.

    - text

      Toast 메세지에 띄울 텍스트를 문자열로 입력한다.

    - duration

      Toast 메세지가 보여지는 시간을 지정한다



### Swipe Event

> Touch Event는 디스플레이에 손가락이 닿을 때, 디스플레이 위에서 움직일 때, 디스플레이에서 손가락을 땔 때 각각 발생한다.
>
> 이를 이용해서 손가락이 닿을 때의 x 좌표와 손가락이 떨어질 때의 x 좌표를 비교해
>
> Swipe로 인식하도록 한다.

> 이전 예제는 Activity에서 Touch Event를 인식했다.
>
> 이번에는 Layout에서 Touch Event를 Handling 하여 Event를 처리한다.

- xml에서 Layout에 Id 설정

  ```xml
  <LinearLayout 
      .....
      android:id="@+id/myLayout">
  ```

- id를 이용해 Layout 객체 생성, Handler 설정

  ```java
  private double x1, x2;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_example05_swipe);
  
      ll = (LinearLayout) findViewById(R.id.myLinearlayout);
      ll.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              return false;
          }
      });
  
  }
  ```

- Touch Event를 구분하여 Swipe 로 인식

  ```java
  @Override
  public boolean onTouch(View v, MotionEvent event) {
      String msg = "";
      if(event.getAction() == MotionEvent.ACTION_DOWN) {
          x1 = event.getX();
      }
      if (event.getAction() == MotionEvent.ACTION_UP) {
          x2 = event.getX();
          if (x1 > x2) {
              msg = "Left Swipe";
          } else {
              msg = "Right Swipe";
          }
          Toast.makeText(Example05_SwipeActivity.this,
                         msg, Toast.LENGTH_SHORT).show();
      }
  
      return true;
  }
  ```

  - `MotionEvent.getAction()` 메서드를 이용해 event를 구분할 수 있다

    각 이벤트는 상수화 되어 MotionEvent에 포함되어있다

    ```java
    MotionEvent.ACTION_DOWN
    MotionEvent.ACTION_UP
    ```

  - `MotionEvent.getX()` 메서드를 이용해 event가 발생한 x 좌표를 구할 수 있다.

    - `getX()`, `getY()` 등의 메서드의 반환형은 `Double`형이다.

  - `getAction()` 메서드를 이용해 event를 구분하고, 

    각 event의 x좌표를 `getX()` 메서드를 이용해 저장한다.

  - Swipe 가 종료되는 `MotionEvent.ACTION_UP` 상태에서 event의 x좌표를 비교하여 Swipe의 방향을 결정한다.

  - Swipe 방향을 Toast 메세지로 출력한다.



