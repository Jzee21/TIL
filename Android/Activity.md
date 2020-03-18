# Activity

> Android Component 중 하나
>
> (Activity, Service, Broadcast Receiver, Content Provider)

- Android Application이 실행되는 기본적인 단위
- Android App의 화면 1개
- UI를 담당하는 Component
- 사용자의 Event 처리를 담당
- Load가 많은 작업처리는 지양한다



- Activity는 App을 구성하고 있는 화면을 지칭화면을 표현하고 관리하기 위한 class

- 화면을 표현할 때는 Activity 하나와 하나 이상의 xml 파일이 필요하다

- Activity 내에서 자바코드로 화면구성을 할 수는 있으나, 권장되지 않음

  (표현과 구현이 분리되지 않기 때문)

- Application은 일반적으로 여러개의 Activity로 구성



## Activity Life Cycle

> activity는 사용자에 의해서 이벤트가 발생되면 그 상태가 변한다.
>
> 그에 따라 callback method가 호출되는데 그 callback method에 대해 알아야한다.

1.  Activity는 class 상태로 존재
2.  Activity가 화면에 나타나려면 객체화가 되어야 한다.(instance화)
3.  onCreate() method가 callback된다. >> 화면구성을 주로 한다.
4.  onStart() method가 callback된다.  >> Activity의 초기화 작업을 한다.
5.  Activity가 foreground로 나타나면서 사용자와 interaction이 가능
6.  onResume() method가 callback된다.
7.  Activity가 running 상태가 된다
8.  Activity의 일부분이 보이지 않는 상태(Pause 상태)
9.  Pause 상태가 되면 onPause() method가 callback된다
10.  Activity의 전체가 완전히 가려져서 보이지 않는 상태가 된다(Stop 상태)
11.  Stop 상태가 되면 onStop() method가 callback된다
12.  만약 Stop 상태에서 다시 Running 상태가 되면
13.  onRestart() -> onStart() -> onResume() 순서로 다시 호출
14.  사용하고 있는 activity를 종료하게되면 killed 상태로 진입
15.  진입하기 전에 onDestory() method가 callback된다
     - 사용한 리소스 초기화, 반납



![img](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile26.uf.tistory.com%2Fimage%2F2042E5504FD938C9289E88)





## Activity 추가

![image-20200318103151904](Image/image-20200318103151904.png)



![image-20200318103254908](Image/image-20200318103254908.png)

![image-20200318103420994](Image/image-20200318103420994.png)

> `!`  Activity를 추가하면 에러가 발생한다.
>
> 이 경우 프로젝트를 refresh 하고 프로젝트를 재시작 하여 해결할 수 있다.

![image-20200318103444214](Image/image-20200318103444214.png)

![image-20200318103515799](Image/image-20200318103515799.png)



## Layout

![레이아웃 종류](https://t1.daumcdn.net/cfile/tistory/261CF539579846111B)

1. LinearLayout
2. RelativeLayout
3. FrameLayout
4. TableLayout
5. ListView와 GridView



### LinearLayout

- `activity_main.xml`

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_height="match_parent"
      android:layout_width="match_parent"
      android:orientation="vertical">
  
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:layout_weight="1"
          android:background="@color/colorYellow"
          android:orientation="horizontal">
          
          <!-- Button들 생략 -->
  
      </LinearLayout>
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:layout_weight="1"
          android:background="@color/colorBlue"
          android:orientation="vertical">
          
          <!-- Button들 생략 -->
  
      </LinearLayout>
  
  </LinearLayout>
  ```

  ![image-20200318130153291](Image/image-20200318130153291.png)

  

  - Layout 안에 Layout을 넣는 등 다양한 방법으로 사용 가능하다.

  - ```xml
    <LinearLayout>
    	<LinearLayout
            .....
            android:layout_weight="1"
            .....>
        </LinearLayout>
        <LinearLayout
            .....
            android:layout_weight="1"
            .....>
        </LinearLayout>
    </LinearLayout>
    ```

    하위 component들에 `layout_weight` 항목이 있을 때,

    각 component들의 사이즈가 상위 component의 크기에서 비율로 나누어 사용한다.

  

`ScrollView`

![image-20200318134735837](Image/image-20200318134735837.png)

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        android:orientation="vertical">

        <EditText
            android:id="@+id/editText2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="TextView" />
        
        <!-- 생략 -->
        
        <RatingBar
            android:id="@+id/ratingBar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </LinearLayout>
</ScrollView>
```





@id/eventBtn

해당 id를 찾는다

@+id/eventBtn

해당 id를 추가한다.





## Event 처리

> Event  -  사용자 혹은 시스템에 의해서 발생되는 모든 것



### Event Handling 

>  Java  -  `Event Delegation Model`을 이용해 Event 처리

Event 처리와 관련된 3가지 객체

1. Event Source 객체
   - Event가 발생한 객체를 지칭
2. Event Handler 객체(Listener)
   - Event를 처리하는 객체
3. Event 객체
   - 발생된 Event에 대한 세부정보를 가진 객체

> Event Source는 이미 생성됨, Event 객체는 자동적으로 생성
>
> Event Source에 Event Handler를 부착시켜
>
> Event가 발생되면 부착된 Handler를 통해 Event를 처리



```java
public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // 1. Event Source instance
        Button myBtn = (Button) findViewById(R.id.eventBtn);
        TextView tv = (TextView) findViewById(R.id.myTv);
        // 2. Event Handler instance - create
        MyEventHandler handler = new MyEventHandler(tv);
        // 3. Event Source에 Event Handler 부착
        myBtn.setOnClickListener(handler);

    }
}
```

```java
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

> 여기서 필요한 것은 일반 클래스의 객체가 아닌
>
> 이벤트를 처리할 수 있는 특수한 능력을 가지고 있는 리스너 객체가 필요
>
> (즉, 특수한 interface를 구현한 클래스여야 한다)
>
> (특수한 interface는 여러개가 존재한다)(Event 종류에 따라서)

> **실제 구현에서는 anonymous inner class(익명 이너클래스)를 이용하기 때문에**
>
> **위와 같은 외부 class는 사용하지 않는다.**



`anonymous inner class`

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
        // onCreate()가 종료되어도 변수가 존대하도록 한다.(생존시간 증가)

        // 2+3. Event Source에 Event Handler 객체를 생성헤서 부착
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Clicked");
            }
        });

    }
}
```



