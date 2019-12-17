package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

public class Test02 {

	public static void main(String[] args) {
		/*
		 *	Inner class 
		*/
		A a = new A("아기상어");
		a.print();					// 아**
		
		A.B b = new A().new B();	// Inner class B
		b.print();					// 홍길동
		
		A.B b2 = a.new B();			// already setNameed class A's Inner class
		b2.print(); 				// 아기상어
		
		//
	}

}

class A {
	String name = "홍길동";
	
	public A() {}
	public A(String name) {
		this.name = name;
	}
	
	void print() {
		System.out.println(name.charAt(0) + "**");
	}
	
	// Inner class
	// A$B.class
	class B {
		void print() {
			System.out.println(name);
		}
	}
	
}

