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




## Monitor 객체

>  `a Monitor Object`

`하나의 데이터(또는 객체) 마다 하나의 모니터를 결합`할 수 있으며, 모니터는 자신과 결합된 데이터에 동시에 `2개 이상의 쓰레드에 의해 접근할 수 없도록 막는 잠금(lock) 기능`을 제공하여 동기화를 수행한다.



### 동작방식

- 하나의 데이터(또는 객체) 마다 하나의 모니터 객체를 결합할 수 있다 (has)
- 모니터 객체는 현재 락을 획득한 Thread와 Lock Count 정보를 관리한다.
- `Thread Scheduler`에 의해 `Thread 단위`로 모니터락을 획득하거나 반환한다 (use)
- 동기화 블럭(메서드 또는 블럭)을 수행할 때는 동기화 대상과 결합된 모니터락을 획득한 후에 진입이 가능하며, 동기화 블럭을 벗어날 때는 모니터락을 반환한다.






## synchronized 키워드

동기화를 하는 방법 중 `synchronized 키워드`를 사용하는 방법이 있다.

이 키워드를 사용하는 방법은 2가지가 있다.

1. Method 동기화
2. 동기화 블럭



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



### 동기화 블럭

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

  `synchronized` 라는 이름의 메서드 블럭으로 감쌌다

- `synchronized ()`의 매개변수를 모니터 객체(Monitor Object)라고 하며

  해당 블럭은 모니터 객체를 기준으로 동기화 됨을 나타낸다.

  ex) 다수의 `synchronized 블럭`이 동일한 하나의 모니터 객체를 요구할 때,

    한 시간에 다수의 블럭 중 모니터 객체를 `Scheduler`에 의해 전달받은

    단 하나의 메서드만 수행된다.





# Reference Link

[박철우의 블로그 : 자바 동기화 블록(Java Syncronized Blocks)](https://parkcheolu.tistory.com/15)

[천방지축 Developer Note : 자바 Thread 동기화 01_02](https://kiwi99.tistory.com/19)

[MakeYourDay : 모니터란 무었인가?](https://happy-coding-day.tistory.com/8)

