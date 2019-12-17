package day05;

public class Test06 {

	public static void main(String[] args) {
		/*
		 * 	make class Calc
		 * 
		 * 	how to use static, non static func
		 * 
		 */
		
		// before static
//		Calc calc = new Calc();
//		
//		System.out.println(calc);
//		System.out.println(calc.add(99, 44));
		
		// after static
		System.out.println(Calc.add(99, 44));
		System.out.println(Calc.add(55.5, 11.7));
		
		//
	}

}
