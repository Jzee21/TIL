package day04;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 	반복문의 중첩
		 * 
		 */
		
		for ( int i=0 ; i<5 ; i++ ) {
			System.out.printf(" i=%2d |", i);
			for ( int j = 0 ; j < 5 ; j++ ) {
				System.out.printf("  j=%2d", j);
			}
			System.out.println();
		}
		
		System.out.println("======================");
		
		// while
		while ( true ) {
			// 무한루프
			break;
		}
		
		System.out.println();
		System.out.println("while");
		int i = 0;
		while ( i<10 ) {
			System.out.println(i++);
		}
		
		// do while
		System.out.println();
		System.out.println("do while");		
		int j = 0;
		do {
			System.out.println(j++);
		} while ( j<10 );
		
		//
		System.out.println();
		System.out.println("while (boolean)");		
		boolean flag = true;
		while ( flag ) {
//			System.out.println(flag);
			int num = (int) (Math.random()*10);
			System.out.println(num);
			if ( num%3 == 0 ) flag = !flag;
		}
		
		
		
		
		//
		
	}

}
