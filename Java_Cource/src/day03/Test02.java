package day03;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 비트 연산자 사용
		*/
		System.out.println(1<<0);		//	1
		System.out.println(1<<1);		//	2
		System.out.println(1<<2);		//	4
		System.out.println(1<<3);		//	8
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(1>4 & 4<0);	// false		// & : 논리연산자
		System.out.println(1&4);		// 0			// & : 비트연산자
		System.out.println(1|4);		// 5
		/*
		 * 1&4	0000 0			// 자바의정석 121p
		 * 1|4	0101 5
		*/
		
//		int x, y;
//		x = y = 3;			// no error
		
//		int i = j = 3;		// error
		
		System.out.println("======================");
		
	}

}
