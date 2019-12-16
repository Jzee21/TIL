package day05;

public class Calc {
	/*
	 * 	static
	 * 
	 * 	method overloading	( != method overwriting )
	*/
	
	// static func
	// in static, can't use 'this'
	public static int add ( int a, int b ) {
		return a+b;
	}

	
	// Method Overloading *************************!!
	// parameter type or number of parameter
	public static double add ( double a, double b ) {
		return a+b;
	}
	
//	public static int add (int a, int b, int c) {
//		return a+b+c;
//	}
	
	//	가변인자
	// ...a 는 항상 뒤에만 올 수 있다.
	//				  add (char c, int ... a)	: 가능
	//				  add (int ... a, char c)	: 불가능
	public static int add (int ... a) {
		
		int sum = 0;
//		for (int i :a) {
//			sum += i;
//		}
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		return sum;
		
	}
	
}
