# Synchronization

동기화(Synchronization)

하나의 자원을 여러 Thread가 사용하려고 할 때,

한 시점에 하나의 Thread만 사용할 수 있도록 하여 자원을 보호한다.



## Multi-Thread의 문제

> 하나의 공유자원이 동기화 되지 않은 상태에서 멀티쓰레드로 사용되면
>
> 공유된 자원의 안정성과 신뢰성을 보장할 수 없다.



### 문제 예시

> 숫자를 저장하고 1초 후에 숫자를 출력하는 메서드를 갖는  `SharedObject` 객체를 정의하고 멀티쓰레드로 메서드를 수행한다.

```java
public class SharedObject {
	private int number;
	
    public int getNumber() {
		return number;
	}
    
    public void setNumber(int number) {
		this.number = number;
		try {
			Thread.sleep(1000);
			System.out.println(
                "after " + Thread.currentThread().getName() 
                + " : " + this.getNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```

```java
public class MyRunnable implements Runnable {
	
	private EX03_SharedObject obj;
    
    @Override
	public void run() {
		System.out.println(
            Thread.currentThread().getName() + " : " + this.number);
		this.obj.setNumber(this.number);		
	}
}
```

```java
public class ThreadSync {
	
	public static void main(String[] args) {
		SharedObject obj = new SharedObject();
		
		MyRunnable r1 = new MyRunnable(obj, 100);
		MyRunnable r2 = new MyRunnable(obj, 200);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
```

실행 결과

```java
Thread-0 - 100			|  | Thread-1 - 200
Thread-1 - 200			|or| Thread-0 - 100
after Thread-0 - 200	|  | after Thread-1 - 100
after Thread-1 - 200	|  | after Thread-0 - 100
```

> 2개의 Thread에 서로 다른 값을 주었지만
>
> `Scheduler`에 의해 먼저 수행되는 Thread에 따라서 다른 결과가 발생한다.

> 즉, 동일한 객체들이 동시에 접근할 때 그 값이 유지된다고 보장할 수 없다.



## synchronized 키워드

동기화를 하는 방법 중 `synchronized 키워드`를 사용하는 방법이 있다.

이 키워드를 사용하는 방법은 2가지가 있다.

1. Method 동기화
2. 동기화 블록



### Method 동기화

메서드 동기화는 해당 메서드를 가진 인스턴스(객체)를 기준으로 이루어진다.

한 시점에 오직 하나의 메서드만이 동기화된 메서드를 실행할 수 있다.

만일 둘 이상의 인스턴스가 있다면 한 시점에 하나의 쓰레드만이 메서드를 실행할 수 있다



```java
public synchronized void setNumber(int number) {
    this.number = number;
    try {
        Thread.sleep(1000);
        System.out.println(
            "after " + Thread.currentThread().getName() 
            + " : " + this.getNumber());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

- `SharedObject.java` 의 `setNumber()` 메서드에 `synchronized`을 추가했다.

실행결과

```java
Thread-0 - 100
Thread-1 - 200
(1s)
after Thread-0 - 100
(1s)
after Thread-1 - 200
```

> 2개의 쓰레드가 생성된 후 `synchronized 키워드`에 의해서 한 번에 하나의 쓰레드(메서드)씩 수행된다.



### 동기화 블록

동기화를 메서드 전체가 아니라 메서드의 특정 부분만 동기화할 수 있다.

```java
public void setNumber(int number) {
    // Code for synchronization is not needed
    synchronized (this) {
        this.number = number;
        try {
            Thread.sleep(1000);
            System.out.println(
                "after " + Thread.currentThread().getName() 
                + " : " + this.getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

- 메서드 내부에서 동기화를 필요로 하는 데이터의 저장과 출력 부분을

  `synchronized` 라는 이름의 메서드 블록으로 감쌌다

- `synchronized ()`의 매개변수를 모니터 객체(Monitor Object)라고 하며

  해당 블록은 모니터 객체를 기준으로 동기화 됨을 나타낸다.

  ex) 다수의 `synchronized 블록`이 동일한 하나의 모니터 객체를 요구할 때,

    한 시간에 다수의 블록 중 모니터 객체를 `Scheduler`에 의해 전달받은

    단 하나의 메서드만 수행된다.



### Monitor 객체

`a Monitor Object`

`하나의 데이터(또는 객체) 마다 하나의 모니터를 결합`할 수 있으며, 모니터는 자신과 결합된 데이터에 동시에 `2개 이상의 쓰레드에 의해 접근할 수 없도록 막는 잠금(lock) 기능`을 제공하여 동기화를 수행한다.



`Thread Scheduler`는 Runnable 상태에서 Run 상태가 되는 Thread에게 모니터 객체를 주고

Thread가 Block되거나 Terminated 될 때 모니터 객체를 수거한다.



모니터 객체는 다수의 동기화 코드에 있어서 동기화되는 기준을 제시하며,

동일한 하나의 모티너 객체를 사용하는 코드들(동기화 코드 블록) 중에서 한 시간에 모니터 객체를 가진 단 하나의 코드만 수행될 수 있도록 한다.



