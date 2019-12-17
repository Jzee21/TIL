package day02;

public class Test05 {

	public static void main(String[] args) {
		//
		int num = 127;
//		byte num = 127;
		System.out.println(num);
		
//		num ++;
		num = num+1;
//		num = (byte)(num+1);
		System.out.println(num);		// byte result : -128
										// int result : 128
		
		//
		char c = 'a';
		c = '0';
		System.out.printf("Is it Num? : %b\n", Character.isDigit(c));
										// isDigit return boolean
		
		//
		System.out.println("======================");
		System.out.println("abc" + "def");		// abcdef		// String + String			// ! high resource
		System.out.println(1+1+1);				// 3			// int + int + int
		System.out.println(1+1+"1");			// 21			// (int + int) + String
		System.out.println("1"+1+1);			// 111			// (String + int = String) + String
		
		//
		System.out.println("======================");
		String str1 = "100"+1;							// 1001
		int str2 = Integer.parseInt("100") + 1;
		double str3 = Double.parseDouble("100.5") + 1;
		int str4 = (int)(Double.parseDouble("100.5") + 1);
		
		System.out.printf("str1 : %6s | str2 : %6d\n", str1, str2);					// 1001		101
		System.out.printf("str3 : %6.2f | str4 : %6d\n", str3, str4);				// 101.50	101

		//
		System.out.println("======================");
		System.out.println(Math.PI);
				
		//
		
	}

}
