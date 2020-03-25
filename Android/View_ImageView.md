# ImageView

> 어플리케이션 화면에 이미지를 표시할 때 사용하는 뷰(View)이다



## 사용 방법

> ImageView는 기본적으로 이미지를 표시한다.
>
> 표시할 이미지의 경로에 따라 사용법이 조금 다르다.



### 1. 기본

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

