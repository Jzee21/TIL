# Singleton Pattern

객체를 사용할 때 매번 객체를 생성하는 것이 아니라

기존에 생성된 객체를 받아서 사용하기 위해 사용하는 Design Pattern



## 특징

- 고정된 메모리 영역을 사용하여 단 한변 new 연산자로 인스턴스를 얻어와

  메모리의 낭비를 줄인다

- 전역변수로 선언되고 전역메서드로 호출하기 때문에 다른 클래스에서 사용하기 편리하다

- 공통된 객체를 사용하는 코드에서 매번 객체를 생성하지 않고 같은 객체를 사용함으로서 성능상에서 훌륭하다



## 구현

```java
public class Singleton {
	private static Singleton instance = new Singleton();
	private Singleton() {
		System.out.println("created");
	}
	public static Singleton getInstance() {
		if (instance == null) {
			instance =  new Singleton();
		}
		return instance;
	}
}
```

- `Singleton` 클래스는 자신의 객체(instance)를 가진다

- `getInstance()` 메서드를 이용해 `Singleton` 클래스가 가지고 있는 객체를 반환한다

- `Singleton` 객체의 생성 없이 `getInstance()` 메서드를 호출하기 위해서

  필드변수 `instance`와 메서드 `getInstance()`를 static으로 선언한다

- 외부에서 `Singleton` 객체의 생성을 막기위해 생성자를 private로 선언한다



---

# Reference Link

- [Design Pattern] 자바 싱글톤 패턴 (JAVA Singleton Pattern) by commin

  출처: https://commin.tistory.com/121 [Commin의 일상코딩]