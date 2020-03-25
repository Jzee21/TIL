# ScrollView

## ScrollView란?

>  View에서 위젯이나 레이아웃이 화면을 넘어갈 때 스크롤이 가능하도록 하는 컨테이너로서 FrameLayout을 통해 만들어졌다



## 종류

- ScrollView(수직 - 위아래)
- HorizontalScrollView(수평 - 좌우)



## 주의점

- ScrollView 안에는 단 하나의 View만 넣을 수 있다.
- 따라서, ScrollView 안에 다수의 View를 사용하려면 ScrollView 안에 하나의 레이아웃을 넣고 그 안에서 다수의 View를 구성하는 방법을 사용한다.



## 예제

![image-20200324172052484](Image/image-20200324172052484.png)

위와 같은 화면을 구성하고자 한다.

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
	xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <ImageView
            android:id="@+id/bookDetailImg"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorLightGray"
            android:src="@drawable/image_not_found"
            android:adjustViewBounds="true"
            android:padding="20dp"/>
        
        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="@color/colorDarkGray"/>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Title_Test"
                android:textSize="12pt"
                android:padding="20px"/>

            <TextView
                .../>

            <TextView
                .../>

            <TextView
                .../>

        </LinearLayout>

    </LinearLayout>

</ScrollView>
```

- ScrollView 내부에 LinearLayout을 하나 두고 내부에 자유롭게 배치했다

- LinearLayout 내부에 ImageView와 또 다른 LinearLayout을 두어 TextView들을 묶어 관리한다

- ScrollView를 사용할 경우, 하위 View들의 속성 중

  부모 View의 높이를 기반으로 하는 

  ```xml
  android:layout_height="match_parent"
  ```

  속성이나

  ```xml
  android:layout_weight="1"
  ```

  와 같은 속성들이 효력을 잃는다.