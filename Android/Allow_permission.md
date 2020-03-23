# Allow permission

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



