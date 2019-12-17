package day02;
/*
 * Week 01
 * 	day 02	(19. 12. 03)
 * 
 * 
*/

public class Test01 {
	// Class의 구성요소
	// Data + 	기능
	// 변수		함수(method)
	
	public static void main(String[] args) {
		// Data
		
		// 기본형
		int i = 900;
		double f = 99.9;
		char c = 'A';			// ASCII Code 65
		boolean b = true;
		
		int c2 = c;				// int <- char
		int c3 = 97;			// ASCII Code 'a'
		char c4 = (char)c3;		// char <- (char)**int
								// 형변환 casting**	4byte to 2byte
		
		float f2 = (float) f;	// 					8byte to 4byte
		
		System.out.printf("|%8d |%8.2f |%8c |%8b |\n", i, f, c, b);
//		//	>>>		>>>		>>>		>>	%b : boolean
//		
//		//	2^32 = 4,294,967,296
//		long i2 = 999999999999999999l;
//		System.out.println(i2);
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		System.out.println(f2);
		System.out.println("1/2 = " + 1/2);
		System.out.println("1/2 = " + 1/2.);
		System.out.printf("d 1/2 = %d", 1/2);
		System.out.printf("f 1/2 = %.2f", 1/2.);
		
		
	}

}
