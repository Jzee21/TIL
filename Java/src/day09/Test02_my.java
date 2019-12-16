package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

public class Test02_my {

	public static void main(String[] args) {
		/*
		 * 
		*/
//		MyA01 a1 = new MyA01();
//		System.out.println(a1.name);
//		
//		MyB01 b1 = new MyB01();
//		b1.print();				// Error.
		//
		
//		MyB03 b3 = new MyB03();		// Error. 기본생성자 x
		MyB03 b3 = new MyB03(new MyA03("18"));		//
		b3.print();
		
	}

}

class MyA01 {
	String name = "A";

}

class MyB01 {
	MyA01 a;				//	1.
//	A a = new A();		// 	2.
	void print() {
//		System.out.println(name);		// Error.
		System.out.println(a.name);		// 1. Error. NullPointException
	}									// 2. no Error.
}
//==================================================
class MyA03 {
	String name ;
	
	public MyA03 (String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class MyB03 {
	MyA03 a;
	
	// B3()		not exist
	MyB03 (MyA03 a3) {
		super();
		this.a = a3;
	}
	
	void print() {
		System.out.println(a.name);
	}
	
}

// ==================================================
// most easy way
class MyA02 {
	String name = "A2";
	
	class MyB02 {
		void print() {
			System.out.println(name);
		}
	}
}
