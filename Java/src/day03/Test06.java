package day03;

public class Test06 {

	public static void main(String[] args) {
		/*
		 *	Loop
		 *		for 문
		 *
		 *	+
		 *	String
		 *		charAt()
		 * 
		 */
		System.out.println("======================");
		
		
		for ( int i=0 ; i<5 ; i++ ) {
			System.out.printf("%d hello world\n", i+1);			
		}
		
		// sum of 1~10
		int sum = 0;
		for ( int i=1 ; i<=10 ; i++ ) {
			System.out.printf(" %d", i);			
			sum += i;
		}
		System.out.println();
		System.out.println(sum);

		//
		sum = 0;
		for ( int i=1 ; i<=10 ; i++ ) {
			if (i%2 == 0 ) {
				System.out.printf(" %d", i);
				sum += i;
			}			
		}
		System.out.println();
		System.out.println(sum);
		System.out.println();
		System.out.println("======================");
		
		String msg = "hello java";
		System.out.println(msg);
		System.out.println("---");
		for ( int i=0 ; i<msg.length() ; i++ ) {
			System.out.println(msg.charAt(i));
		}
		System.out.println("---");				// reverse
		for ( int i=msg.length()-1 ; i>=0 ; i-- ) {
			System.out.println(msg.charAt(i));
		}
		System.out.println("---");
		// self test
//		System.out.println(msg);				// "hello java"	.length() = 9
//		System.out.println(msg.charAt(20));		// Error : String index out of range
		
		
		//
		System.out.println();
		System.out.println("======================");
		
	}

}
