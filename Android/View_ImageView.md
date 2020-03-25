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

