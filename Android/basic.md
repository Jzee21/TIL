# Android

## 목표

- Component들의 동장방식에 대한 이해
  - Android 주요 컴포넌트
    1. Activity
    2. Service
    3. Broadcast Receiver
    4. Content Provider

- Android Framework의 동작원리



## Android란?

> Google이 만든 휴대기기용(스마트폰, 태블릿) 플랫폼



### Android의 구성

> OS(Linux Kernel) + 미들웨어 + 핵심 어플리케이션(전화, 카메라, 메시지 등)과 같은 것들이 포함되어 있는 모바일 디바이스를 위한 소프트웨어 스택
>
> ![img](http://www.epnc.co.kr/news/photo/200908/44850_40800_1.jpg)
>

- OS(Linux Kernel)
- Middleware
  - Library, Android Runtime
- Application Framework
- Application



### Android의 특징

- 오픈소스

- 개발언어 - Java, Kotlin

- 앱간의 연동이 자유롭다.  

- JDK  :  Dalvik  >>  ART (Android Runtime)



#### Android 역사

- 2005년 구글이 Android 사를 인수
- 2007년 안드로이드 발표
- 2008년 오픈소스 공개
- 2014년 안드로이드 5.0 공개
  - ART(Android Runtime) 탑재
- 2019년 9월 안드로이드 10(Q) 공개



#### Android 버전

> Android는 버전 이름을 알파벳 순서로 붙여왔다.
>
> 1.5 버전부터 디저트명을 별명으로 붙여왔으며 10 버전부터는 디저트명을 사용하지 않는다.

- 주요 버전
  - (앞 생략)
  - N (7.0)  -  Nougat
    - 파일 기반 암호화 지원
  - O (8.0)  -  Oreo
    - 화면 잠금과 관련된 보안정책 변경
  - P (9.0)  -  Pie
    - 볼륨 버튼을 누르면 먼저 미디어 볼륨을 조정함
  - Q (10.0)
    - 어두운 테마 지원
    - 스와이프 제스처 지원(IOS와 유사)



#### 성장 배경

> Android가 빠르게 시장점유율을 높일 수 있었던 이유

- 오픈소스

- Eco System이 잘 되어있다.

  - 단말기 제조사, 이동통신사, 어플리케이션 개발자 등

    안드로이드의 성장에 참여하는 범위가 넓음



#### Framework

> Android는 Framwork이다.

`!`  `Library vs Framework`

- Library는 특정 기능을 쉽고 편하게 구현할 수 있다.
  - 시스템 구성은 개발자가 설계
  - 유지보수가 힘들다
- Framework는 동작 방식이 정해져있다.
  - Framework을 이해해야 개발이 가능하다.
  - 유지보수가 쉽다



### Android Component

> Android를 구성하는 4가지 주요 Component

#### 1. Activity

- Android Application이 실행되는 기본적인 단위
- Android App의 화면 1개
- UI를 담당하는 Component
- 사용자의 Event 처리를 담당
- Load가 많은 작업처리는 지양한다



#### 2. Service

- 내부 로직처리를 담당
- 데이터베이스 연결, 네트워크 연결
- 사용자와의 interaction은 담당하지 않는다
- 일반적으로 Background에서 로직처리를 담당



#### 3. Broadcast Receiver

- Android System에서 발생되는 여러가지 신호(Broadcast)를 받아서 적절한 처리를 하는 Component



#### 4. Content Provider & Resolver

- 모든 Android App은 Sandbox Model을 이용
- App 간의 데이터 공유





## 개발환경 설정

> 1. JDK  1.8.0
> 2. Android Studio  3.6.1
> 3. AVD(Android Virtual Device) & real device



### Android Studio 설치

- [Android Developers](https://developer.android.com/) - [Download Android Studio](https://developer.android.com/studio)

- `android-studio-ide-192.6241897-windows.exe` 실행
  1. Next
  2. Android Virtual Device 체크 확인
     - AVD(Android Virtual Device) 사용 여부를 확인한다
     - Default  :  checked
     - ![image-20200317103035038](Image/image-20200317103035038.png)
     - 설치경로 지정
     - install



> `!`  Android Studio를 삭제할 때,
>
> 제어판에서 삭제를 한 후에 설치폴더, 환경설정이 남아있는 경우
>
> 해당 설정과 경로를 수동으로 삭제해야한다.



### Android Studio 설정

- 최초 실행 시 기존의 설정을 적용할지 묻는다.
- Config of installation folder
  - 기존에 사용하던 Android Studio의 설정양식을 적용한다.
  - Do not import settings
    - 기본값으로 설정한다.

![image-20200317103218700](Image/image-20200317103218700.png)



- ![image-20200317103714720](Image/image-20200317103714720.png)

  > Next

- ![image-20200317103732586](Image/image-20200317103732586.png)

  > UI등의 사용자 정의 설정을 진행할지 여부
  >
  > Standard  -  Next

- ![image-20200317103748281](Image/image-20200317103748281.png)

  > UI  -  Dark  / Light
  >
  > 난 무조건 Dark

- ![image-20200317103808916](Image/image-20200317103808916.png)

  > 추가로 설치될 목록과 필요 용량에 대한 설명
  >
  > 기본적으로 Android 최신버전(10, Q)가 설치된다.

- ![image-20200317103832801](Image/image-20200317103832801.png)

  > Android 10 installing.....

- ![image-20200317110223562](Image/image-20200317110223562.png)

  > 설치 완료




#### SDK 설정

- ![image-20200317110329025](Image/image-20200317110329025.png)

  > 설치가 완료된 화면
  >
  > `Configure` - `SDK Manager`

- ![image-20200317110420111](Image/image-20200317110420111.png)

  > `Android 9.0 (Pie)`, `Android 8.0 (Oreo)` 선택 (추가 설치)

- ![image-20200317110526730](Image/image-20200317110526730.png)

  > 상단 탭 `SDK Tools` - `Google Play service` 선택 (추가 설치)
  >
  > `Apply`

- ![image-20200317110554955](Image/image-20200317110554955.png)

  > Licence  `Accept` - `Next`
  
- ![image-20200317112111350](Image/image-20200317112111350.png)

  > Android 8, Android 9, 각 버전의 SDK 설치





#### AVD Manager

- ![image-20200317110849353](Image/image-20200317110849353.png)

- ![image-20200317110903646](Image/image-20200317110903646.png)

  > Create Virtual Device

- ![image-20200317112147961](Image/image-20200317112147961.png)

  > Nexus 5 선택

- ![image-20200317112250585](Image/image-20200317112250585.png)

  > 해당 기기와 버전에 맞는 이미지 설치
  >
  > `Pie Download`

- ![image-20200317112317082](Image/image-20200317112317082.png)

- ![image-20200317112502678](Image/image-20200317112502678.png)

- ![image-20200317112744121](Image/image-20200317112744121.png)

  > AVD 세부 설정

- ![image-20200317112749295](Image/image-20200317112749295.png)

  > 설치된 AVD들의 리스트



## Android Studio Project

### 생성

- ![image-20200317113718244](Image/image-20200317113718244.png)

- ![image-20200317113724589](Image/image-20200317113724589.png)

  > 다양한 종류의 Activity 양식을 기본으로 제공한다.

- ![image-20200317114836131](Image/image-20200317114836131.png)

  > Name  :  App 의 이름
  >
  > Package Name  :  다른 앱과 구분되는 기준
  >
  > ​		- unique한 값을 사용해야 하며, 주로 도메인의 역순으로 많이 사용한다.
  >
  > Language  :  Java   (default  :  Kotlin)
  >
  > Minimum SDK  :  구동 가능 Android 최소 버전

- ![image-20200317114859144](Image/image-20200317114859144.png)




### 구성

![image-20200317115049448](Image/image-20200317115049448.png)

> `!`  Gradle
>
> Spring의 Maven과 같은 역할

![image-20200317115216358](Image/image-20200317115216358.png)



#### Directory View

> 여러가지 방식으로 프로젝트를 구성하는 파일들을 볼 수 있다.
>
> 주로 쓰이는 방식 3가지

- Project

  ![image-20200317115510369](Image/image-20200317115510369.png)

- Package

  ![image-20200317115529476](Image/image-20200317115529476.png)

- Android

  ![image-20200317115553049](Image/image-20200317115553049.png)

> Project View는 `Android`를 기본으로 하며, 설정 파일은 `Project`를 통해 확인한다.



#### AndroidManifest.xml

`app  -  mainfests  -  AndroidMainfest.xml`

![image-20200317130256603](Image/image-20200317130256603.png)

> App과 프로젝트 전반에 대한 정보를 갖고있다.
>
> ```xml
> <activity android:name=".MainActivity">
>                  	<!--    class name    -->
> 	<intent-filter>
> 		<action android:name="android.intent.action.MAIN" />
> 
> 		<category android:name=
>                   "android.intent.category.LAUNCHER" />
>                           <!--  앱 실행시 보이는 첫 Activity  -->
> 	</intent-filter>
> </activity>
> ```



#### MainActivity.java

```java
package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /* onCreate()	(callback method)
        특정 시점이 되면 Android System에 의해서 자동으로 호출
        (해당 클래스의 instance가 생성될 때) */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* activity_main.xml 파일을 이용해서
           activity의 View를 설정하는 method  */
        setContentView(R.layout.activity_main);
    }
}
```

> 주로 Activity에 대한 로직을 담당한다.



####  activity_main.xml

![image-20200317141353161](Image/image-20200317141353161.png)

![image-20200317141512789](Image/image-20200317141512789.png)

> `MainActivity.java`에서는 화면의 구동에 대한 로직을 주로 담당한다면
>
> `activity_main.xml`에서는 화면의 구성요소들의 위치 등의 UI를 담당한다



#### res

1. drawable  : application 에서 사용하는 그림 파일 저장
2. layout    : Activity에서 사용할 화면구성을 위한 xml 파일 저장
   - xml 파일의 이름은 무조건 소문자로 해야한다.
3. mipmap    : launcher icon과 같은 이미지 자원을 저장
4. values    : 문자열이나 컬러와 같은 다양한 자원에 대한 정보를 저장



#### Logcat

> Android System에서 발생하는 Log들을 이용해
>
> 현재 구동중인 Android의 상태를 확인할 수 있다.

![image-20200317141034398](Image/image-20200317141034398.png)

- IDE의 하단에 `Logcat` 탭이 존재하며, 다양한 필터를 이용해 원하는 Log만 확인할 수 있다.
- `Log.i()`
  - tag와 msg로 구성되어 Log를 생성한다.
  - Android App 개발 시 App의 동작 사이에 두어 Debuging에 활용할 수 있겠다.

