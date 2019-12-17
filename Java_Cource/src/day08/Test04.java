package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test04 {

	public static void main(String[] args) {
		/*
		 *	Test03		: Has a 관계
		 *
		 *	AnimalTest	: abstract 사용 시 접근제어자 범위 테스트	
		 *
		 * 	Test04		: Object 상속 	// override toString, equals
		*/
		
		String msg1 = "Hello";
		String msg2 = "Hello";
		
		Person p1 = new Person("홍길동", 22);
		Person p2 = new Person("홍길동", 22);
		Person p3 = null;
		
		System.out.println(msg1.equals(msg2));		// true
		System.out.println(p1.equals(p2));			// false				// true
													// before overriding	// after override
		System.out.println(p1.equals(p3)); 									// false
		
		// ===============================================
		//		12.11 오전 ㄱ
		// ===============================================
		System.out.println("==== morning ====");
		
		System.out.println(msg1.toString());		// 결과가 동일하다.
		System.out.println(msg2);					// 즉, 주소를 출력하면 toString이 자동 실행되어 출력된다.
		
		System.out.println(p1);						// 컴파일러에서 오토컨버팅 ( p1 -> p1.toString )
		System.out.println(p2.toString());			// toString override 후 출력형식 변경
		
		//
		System.out.println("==== obj ====");
		Object obj = p1;
		System.out.println(obj);							// Person[홍길동 : 22]
		System.out.println(((Person)obj).name);				// 홍길동

		obj = msg1;
		System.out.println(obj);							// Hello
		System.out.println(((String)obj).toUpperCase());	// HELLO
		//
	}

}

class Person {
	
	String name;
	int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
//		return getClass().getName() + "@" + Integer.toHexString(hashCode());	// Object.toString()
		return "Person[" + name + " : " + age + "]";
		
	}
	
	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		// by Professor.
		if (anObject instanceof Person) {
			Person p = (Person) anObject;
			if (name.equals(p.name) && age == p.age) {
				return true;
			}
			
		}
		
		// by Me.
//		if (anObject instanceof Person) {
//			if ( ((Person)anObject).name.equals(this.name) ) {
//				if ( ((Person)anObject).age == this.age ) {
//					return true;
//				}
//			}
//		}
		
		return false;

    }
	
}