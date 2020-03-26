# Permission

> Android Application의 보안 정책에 따라
>
> 사용자의 민감한 데이터나 특정 시스템 기능을 사용하기 위해서는
>
> 이에 엑세스 하기 위한 권한을 요청해야 한다.
>
>  
>
> `AndroidManifest.xml` 파일에는
>
> Android 빌드 도구, Android 운영체제 및 Google Play에 앱에 관한 필수 정보를 가진다.



## 앱 권한 요청

> Android 6.0 (Marshmallow) 이상에서는 manifest 파일에 기술하는 것 이외에 추가적인 권한을 요구한다

> 앱마다 사용자에게 권한을 요청하고 요청이 허용되어야 해당 기능을 이용할 수 있다

- 일반 권한(Normal Permission)
- 위험 권한(Dangerous Permission)
  - 위치, 전화, 카메라, 마이크, 문자, 일정, 주소록, 센서 등
  - 사용자의 개인정보와 관련된 모든것



### 예제

[전화걸기 권한 설정]





## 권한 확인

> 각각의 Application 마다 권한을 확인하고, 수정할 수 있다.

설정  -  애플리케이션  -  `확인할 앱` - 권한

![image-20200326112110160](Image/image-20200326112110160.png)







## Network에 연걸

Application에서 Network 작업을 수행하기 위해서는 `mainfest`에 다음과 같은 권한을 포함해야 한다.

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

또는 (하나 또는 두개의 권한)

```xml
<uses-permission 
	android:name="android.permission.INTERNET" />
<uses-permission 
	android:name="android.permission.ACCESS_NETWORK_STATE" />
```



## HTTP 접속

HTTP 프로토콜로 네트워크에 접속하기 위해서는 `mainfest`에 다음과 같은 내용이 포함되어야 한다.

```xml
<application
	android:usesCleartextTraffic="true"
	.....>
</application>
```

> Android 9.0 (Pie) 버전 부터는 기본 Web Protocol이 HTTP에서 `HTTPS`로 변경되었다.
>
> 이에 따라 HTTP 프로토콜을 사용하기 위해서는 위와 같은 특수한 설정이 추가로 필요하다.
