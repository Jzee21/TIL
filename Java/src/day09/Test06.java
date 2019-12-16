package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

public class Test06 {

	public static void main(String[] args) {
		/*
		 *	make Error
		 *
		 *	throw - catch Error
		*/
		
		System.out.println("Start");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ======================================
		
		try {
			throw new Exception("Error Exception example.");	// 고의 발생
			// 예외 발생
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* result
		 * java.lang.Exception: Error Exception example.
					at day09.Test06.main(Test06.java:27)
		 */
		
		
		System.out.println("End");
		//
	}

}
