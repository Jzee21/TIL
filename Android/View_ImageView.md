# ImageView

> 어플리케이션 화면에 이미지를 표시할 때 사용하는 뷰(View)이다



## 사용 방법

> ImageView는 기본적으로 이미지를 표시한다.
>
> 표시할 이미지의 경로에 따라 사용법이 조금 다르다.



### 1-1. 기본

> 이미지 파일이 Application 내부의 리소스 사용하기

- Layout 리소스 XML 파일에 ImageView를 추가한다.

- 화면에 표시할 이미지의 리소스(res - Drawable)의 id를 

  `src` 속성에 지정한다.

> `android_icon.png`

```xml
<ImageView
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:id="@+id/imageView1"
	android:src="@drawable/android_icon"/>
```



### 1-2. Activity 지정

> ImageView에 표시할 이미지를 XML이 아닌 Java 코드에서 지정하기

- Layout 리소스 XML 파일에 ImageView를 추가한다.
- Avtivity에서 ImageView 인스턴스의 메서드를 이용해 id를 지정한다.

```java
ImageView imageView = (ImageView) findViewById(R.id.imageView1);
imageView.setImageResource(R.drawable.android_icon);
```



### 2. 외부 이미지

> 이미지 파일이 Web 주소 형태로 주어질 때

- Web으로부터 파일 주소를 이용해 Image를 불러온다.
  - Network 기능을 사용하기 때문에 권한설정이 필요하다. [Permission 설정](https://github.com/Jzee21/TIL/blob/master/Android/Allow_permission.md)
  - Network 를 통해 이미지를 불러와야 하기 때문에 Thread를 이용한 별도의 작업흐름을 이용해야한다. [Thread 사용](https://github.com/Jzee21/TIL/blob/master/Android/Thread.md)
- 받아온 이미지는 `Bitmap` 객체에 저장한다.
- `ImageView.setImageBitmap()` 메서드를 이용해 Bitmap 객체를 ImageView에 지정한다.

```java
// Web으로부터 Image를 불러와 Bitmap으로 반환
private Bitmap getBookImg(String url) {

    URL imgUrl = null;
    HttpURLConnection connection = null;
    InputStream is = null;
    Bitmap retBitmap = null;

    try{
        imgUrl = new URL(url);
        connection = (HttpURLConnection) imgUrl.openConnection();
        connection.setDoInput(true);
        connection.connect();
        is = connection.getInputStream();   // get inputstream
        retBitmap = BitmapFactory.decodeStream(is);
    } catch(Exception e) {
        e.printStackTrace();
        return null;
    } finally {
        if(connection!=null) {
            connection.disconnect();
        }
        return retBitmap;
    }

}
```

```java
// Image를 불러오는 과정을 Thread로 실행
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            bitmap = getBookImg(book.getImg());
        } catch (Exception e) {

        } finally {
            if(bitmap!=null) {
                runOnUiThread(new Runnable() {
                    @SuppressLint("NewApi")
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            } // if()
        } // finally()
    } // run()
}).start();                   
```



### 3. Base64 이미지

> Web에서 이미지가 전달될때 이미지의 경로를 주거나,
>
> 이미지를 Base64 행태로 디코딩하여 보내는 경우도 있을 수 있다.

- String 형태의 Base64 파일을 불러온다.
  - Web에서 불러올 경우 Thread를 이용한 별도의 작업분기를 이용한다.
- Base64 파일을 `byte[]` 형태로 디코딩한다.
- `BitmapFactory`를 이용해 `byte[]`형태의 이미지를 `Bitmap` 형태로 인코딩한다.
- 인코딩된 Bitmap 파일을 `ImageView.setImageBitmap()`메서드를 이용해 ImageView에 지정한다.

```java
String base64String = book.getImgbase64();
// "data:image/gif;base64,R0lGODlhkQCoAOYAAG9DF25xcf39/ern5fv7+aqS...... 생략
String base64Image = base64String.split(",")[1];

byte[] byteImage = Base64.decode(base64Image, Base64.DEFAULT);
Bitmap bitmap = BitmapFactory.decodeByteArray(
    							byteImage, 0, byteImage.length);
imageView.setImageBitmap(bitmap);
```



### 4. Size 설정

> View에 나타나는 이미지의 사이즈를 설정한다.
>
> 1. View의 설정파일인 XML에서 width와 height를 지정한다
>
>    - 픽셀 크기를 지정하는 방법
>
>    - match_parent, wrap_content 를 이용하여 지정하는 방법
>    - layout_weight 를 이용하여 다른 View들과의 비율로 지정하는 방법
>
> 2. Avtivity에서 ImageView의 `LayoutParams`을 이용해 지정하는 방법
>
>    - 픽셀 크기를 지정하는 방법*
>    - **스크린 사이즈의 비율을 이용해 지정하는 방법****

> ScrollView를 사용할 경우 wrap_content 값이나 layout_weight 속성이 적용되지 않았다.

- ImageView의 크기를 가져오는 방법

  ```java
  ViewGroup.LayoutParams param = imageView.getLayoutParams();
  param.height
  param.width
  ```

  - ImageView의 `getLayoutParams()` 메서드를 이용해

    현재 ImageView가 할당받은 View의 크기를 알 수 있다.

  - 변수명.height 또는 .width 를 이용하여 특정 값을 반환받을 수 있다

  - ScrollView과 layout_weight  속성을 사용했을 때, 음수의 값이 반환되었다...

   

- ImageView의 크기를 지정하는 방법

  ```java
  param.height = 100;
  param.width = 100;
  imageView.setLayoutParams(param);
  ```

  - param 객체의 값을 특정 값으로 변경 후

    `setLayoutParams(param)` 메서드를 이용해 사이즈를 지정할 수 있다

   

- Deviec의 Screen 크기를 가져오는 방법

  ```java
  DisplayMetrics metrics = new DisplayMetrics();
  WindowManager manager = (WindowManager) getApplicationContext()
      .getSystemService(Context.WINDOW_SERVICE);
  manager.getDefaultDisplay().getMetrics(metrics);
  
  metrics.heightPixels;
  metrics.widthPixels;
  ```

  - ... 짜잔

   

- 스크린 크기를 이용한 ImageView의 크기 지정

  ```java
  param.height = (int) (metrics.heightPixels * 0.5);
  param.width = (int) metrics.widthPixels;
  imageView.setLayoutParams(param);
  ```

  - 정수의 값을 지정해준다

   

  또는,

  ```java
  imageView.setMaxHeight((int) (metrics.heightPixels*0.5));
  ```

  다른 View들과의 관계로 인한 동적인 사이즈 조절을 설정하는 대신

  최대 또는 최소 사이즈를 지정할 수 있다.





---

## 주의사항

### Drawable ID

> 리소스 파일의 id에는 생성규칙이 있다.

1. id는 이미지 파일의 확장자를 제외한 이름이다.

   - file  :  `image_01.png`
   - drawable  :  `@drawable/image_01`
   - java  :  `R.drawable.image_01`

    

2. 숫자, 소문자, '_' 문자만 사용할 수 있다.

   - `image_05`  O
   - `Image_05`  X
   - `icon10`  O
   - `아이콘10`  X

   

3. id의 시작은 소문자, '_'문자로만 시작할 수 있다.

   - `_2_img`  O
   - `21_img`   X

