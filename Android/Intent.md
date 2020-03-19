# Intent

## 정의

> 앱 컨포넌트가 무었을 할 것인지를 담는 메세지 객체이다.
>
> 가장 큰 목적은 다른 액티비티, 서비스, 브로드캐스트 리시버, 컨텐트 프로바이더 등을 실행하는 것이다.
>
> 인텐트는 그들 사이에서 데이터를 주고 받기 위한 용도로도 사용된다.



## 화면전환

> 다른 Activity를 호출하는 2가지 방식으로
>
> Explicit 방식과  Implicit 방식이 있다.

### Explicit 방식

> 명시적 방식

> 버튼을 눌렀을 때, 다른 Activity로 이동

![image-20200318173108024](Image/image-20200318173108024.png)



#### Target Activity

- Main Activity에서 이동하길 원하는 다른 Activity를 생성한다.
  - `Example01_LayoutActivity`
    - Example01_LayoutActivity.java
    - activity_example01_layout.xml



#### Main Activity

- `activity_main.xml`

  ```xml
  
  <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_height="match_parent"
      android:layout_width="match_parent">
  
      <LinearLayout
          android:layout_height="match_parent"
          android:layout_width="match_parent"
          android:orientation="vertical">
  
          <TextView
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:padding="50px"
              android:text="Android 예제"
              android:textSize="10pt"
              android:textAlignment="center"
              android:gravity="center_horizontal"
              android:background="@color/colorPuple"/>
  
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical">
  
              <Button
                  android:id="@+id/_01_linearlayoutBtn"
                  android:layout_width="match_parent"
                  android:layout_height="wrap_content"
                  android:text="1. LinearLayout" />
              
              <!-- 추가 예정 -->
  
          </LinearLayout>
  
      </LinearLayout>
  
  </ScrollView>
  ```

  

- `MainActivity.java`

  - id를 등록한 버튼에 Handler를 등록한다.

```java
Button _01_linearlayoutBtn =
		(Button) indViewById(R.id._01_linearlayoutBtn);
_01_linearlayoutBtn.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		
	}
});
```



- Intent 객체 생성
  - Target Activity를 찾아 지정하기 위해서 Intent 객체를 사용한다.

```java
@Override
public void onClick(View v) {
	Intent i = new Intent();
}
```



- Intent 객체 설정

  - ComponentName 객체를 이용해 이동할 Activity를 지정한다

    - 매개변수는 2개이며

    - 첫번째 매개변수는 이동할 Activity가 포함된 Package 경로

    - 두번째 매개변수는 이동할 Activity의 Class 이름

      (Class 이름은 Package의 경로를 포함한다.)

  - ComponentName 객체를 Intent 객체에 연결한다.

  - Intent 객체를 이용해 새로운 Activity를 호출한다.

```java
ComponentName cname = 
    new ComponentName("com.example.androidlectureexample",
 	"com.example.androidlectureexample.Example01_LayoutActivity");
i.setComponent(cname);
startActivity(i);
```



