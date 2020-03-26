# Service

> 메신저 앱이나 스트리밍 앱처럼
>
> 화면에 켜지 않아도 메세지를 수신하거나 음악을 스트리밍 하는 등
>
> 눈에 보이지 않지만 Background에서 실행되는 것들을 구현하는데 주로 사용된다.



---

## Lifecycle

### Activity

- onCreate() > onStart() > onResume() > onPause > onStop()

### Service

- onCreate() > onStartCommand() > onDestroy()



## Create Service

`New - Service - Service*`

> Service로 생성한다.
>
> Service (IntentService)  :  1회용 Service라고 생각하면 된다.

![image-20200326140839752](Image/image-20200326140839752.png)



![image-20200326141058073](Image/image-20200326141058073.png)

- Exported
  - 생성된 Component를 다른 App에서 사용할 수 있도록 허용
- Enabled
  - 서비스가 사용 가능한 상태로 생성할 것



```java
public class ___Service extends Service {
    public ___Service() {
    }
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException(
            "Not yet implemented");
    }
}
```



### Method Override

> 주로 사용하게 될 Method
>
> onCreate(). onStartCommand(), onDestroy()

```java
@Override
public void onCreate() {
    super.onCreate();
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);
}

@Override
public void onDestroy() {
    super.onDestroy();
}
```

- onCreate()
  - `Service`가 생성될 때 호출된다
- onStartCommand()
  - 실제 Service 동작을 수행하는 부분
  - Service가 동작중이지 않다면 먼저 `onCreate()`를 호출한 후 실행한다
- onDestroy()
  - `stopService()`가 실행되면 호출된다



## Start Service

### Activity

```java
Intent i = new Intent(getApplicationContext(),
                      ___Service.class);
startService(i);
```

- Intent에 Service의 클래스를 지정한다

- startService(intent) 메서드를 이용해

  Service 의 `onCreate()`를 호출한다.



### Service

`onStartCommand()`

> Activity의 `startService()`가 실행되면 
>
> Service 객체의 생성을 확인하여  `onCreate()` 실행 후 실행되거나
>
> 바로 실행된다.

```java
try {
    // private Thread myThread;
    myThread = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i=0 ; i<10 ; i++) {
                try {
                    Thread.sleep(1000);     // 1 sec
                    // interrupt point
                    Log.i("ServiceExam", "count : " + i);
                } catch (Exception e) {
                    Log.i("ServiceExam", 
                          "["+i+"] e : " + e.toString());
                }
            }// for()
        }// run()
    }).start();
} catch (Exception e) {
    Log.i("ServiceExam", "Thread.start() : " + e);
}
```

- onStartCommend() 내부에서 Thread를 이용해 작업을 처리한다.



## Stop Service

### Activity

```java
Intent i = new Intent(getApplicationContext(),
                      ___Service.class);
stopService(i);
```

- Intent에 Service의 클래스를 지정한다

- stopService(intent) 메서드를 이용해

  Service 의 `onDestroy()`를 호출한다.



### Service

`onDestroy()`

> 서비스가 사용한 자원에 대해 정리 하도록 유도하는 메서드

```java
if (myThread != null && myThread.isAlive()) {
    myThread.interrupt();
}
```

- ( 기존에는 Thread.stop() 메서드를 이용해 쓰레드를 강제종료 했다

  강제 종료에는 많은 Exception을 발생시켜 현재는 사용하지 않는다 )

- 서비스에서 사용한 myThread 쓰레드가 존재하고, 아직 작동중이라면

  해당 쓰레드에 `interrupt` 를 발생시킨다.

- `interrupt`는 Thread가 `Sleep` 상태에 들어가고자 할 때,

  강제적으로 Exception을 발생시켜 Thread가 작업중이 아닌 유휴상태일 때, Thread의 작업 종료를 유도한다

- 따라서, Thread에서는 `interrupt`에 대응한 예외처리가 필요하다





## Activity와 Service의 차이점

1. Lifecycle이 다르다

   - 위의 Lifecycle에서 비교한 바와 같다

2. 자동적으로 다시 시작할 수 있다

   - Activity는 종료 시 사라지지만(자동으로 살릴 수 없다)

     Service는 도중에 의도치 않게 중료되어도 자동으로 중단된 지점에서 **`다시 시작할 수 있다`**

