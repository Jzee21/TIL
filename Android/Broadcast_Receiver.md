# Broadcast Receiver



## Broadcast란?

> Android 에는 Broadcast라는 signal이 존재한다.
>
> 이 신호(signal)은 Android System 자체에서 발생할 수도 있고,
>
> 사용자 App에서 임의로 발생시킬 수 있다.

> Android System 자체에서 발생하는 Broadcast Signal은
>
> 전화를 수신하거나 네트워크의 전환, 배터리 상태 변화 등이 발생했을 때
>
> Android System이 발생시킨다.



## Broadcast Receiver란?

> Android의 4가지 Component 중 하나

> Android 내부에 전체적으로 발송된 Broadcast Signal 중
>
> 특정 Broadcast 신호를 수신하고 이를 반응하기 위해 사용된다.



## Receiver 등록

> 등록하는 방법에는 2가지가 있다.
>
> 1. AndroidManifest.xml 파일에 명시 (정적 등록)
> 2. 코드 상에서 Receiver를 만들어서 등록 (동적 등록)



### 1. 정적 등록

> 외부 `Broadcast Receiver Component` 를 생성하고,
>
> 이를 `AndroidManifest.xml` 파일에 명시하여 등록한다.

1. 외부 `Broadcast Receiver` 생성

   - `File - New - Other - Broadcast Receiver`

     ![image-20200406103406871](Image/image-20200406103406871.png).

     

   - `AndroidManifest.xml`

     위의 방법으로 생성 시 Manifest 파일에 아래와 같이 자동으로 등록된다.

     ```xml
     <receiver
     	android:name=".{___}BroadcastReceiver"
         android:enabled="true"
         android:exported="true"></receiver>
     ```

      

     

2. 자동으로 추가된 `Broadcast Receiver`에 

   Receiver가 수신한 Broadcast를 `intent-filter`를 추가한다.

   ```xml
   <receiver
   	android:name=".{___}BroadcastReceiver"
       android:enabled="true"
       android:exported="true">
       <intent-filter>
           <action android:name="android.provider.Telephony.SMS_RECEIVED" />
       </intent-filter>
   </receiver>
   ```

    



### 2.  동적 등록

> `Code` 상에서 `Receiver 객체`를 만들어서 등록한다.

1. `IntentFilter` 객체 생성

   ```java
   IntentFilter intentFilter = new IntentFilter();
   intentFilter.addAction("MY_BROADCAST_SIGNAL");
   ```

    

2. Broadcast Receiver 객체 생성

   ```java
   private BroadcastReceiver bReceiver;
   
   bReceiver = new BroadcastReceiver() {
       @Override
       public void onReceive(Context context, Intent intent) {
           // Receiver 가 신호를 받았을 때 수행되는 Method
           if (intent.getAction().equals("MY_BROADCAST_SIGNAL")) {
               Toast.makeText(Example18_BRTestActivity.this,
                              "신호를 수신했습니다.",
                              Toast.LENGTH_SHORT).show();
           }
       }
   };
   ```

    

3. Broadcast Receiver를 Filter와 함께 등록

   ```java
   registerReceiver(bReceiver, intentFilter);
   ```

 

### 3. 동적 등록 해제

```java
unregisterReceiver(bReceiver);
```



## Broadcast 신호 발생

```java
Intent i = new Intent("MY_BROADCAST_SIGNAL");
sendBroadcast(i);
```





---

## 예제 1

> 동적 등록에 사용한 코드

![image-20200406092445191](Image/image-20200406092445191.png).

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Broadcast Receiver 등록"
            android:id="@+id/br_registerBtn"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Broadcast Receiver 해제"
            android:id="@+id/br_unRegisterBtn"/>

    </LinearLayout>

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Broadcast 발생!"
        android:id="@+id/sendBroadcastBtn"/>

</LinearLayout>
```



---

## 예제 2

> SMS 수신 시 발신자와 메세지 내용, 수신 날짜를 Activity에 나타낸다



### 1. SMS 보안설정

1. `AndroidManifest.xml`

   ```xml
   <uses-permission android:name="android.permission.RECEIVE_SMS" />
   ```

2. Activity

   ```java
   
   ```



### 2. Broadcast Receiver 등록

> 외부 Component 생성 후 정적 등록 (AndroidManifest.xml)

```xml
<receiver
	android:name=".{___}BroadcastReceiver"
    android:enabled="true"
    android:exported="true">
    <intent-filter>
    	<action android:name="android.provider.Telephony.SMS_RECEIVED" />
    </intent-filter>
</receiver>
```

