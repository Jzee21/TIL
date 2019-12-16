package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

public class Test05 {

	public static void main(String[] args) {
		/*
		 *  Chapter 8. Exception Handling
		 *  
		 *  catch exception
		*/
		
		System.out.println("Start");
		
//		String msg = "Back";
		String msg = "-5";
		int num = 0;
		int res = 0;
		
		try {
			num = Integer.parseInt(msg);	// <-- Error
			res = 1000/num;
//			int[] number = new int[num];
		} catch (NumberFormatException e) {
			System.out.println(e);
			System.out.println("Number Please.");
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println("Please enter number except zero");
		} catch (Exception e) {
			System.out.println(e);					// java.lang.NegativeArraySizeException
			System.out.println(e.getMessage()); 	// null
			e.printStackTrace();					// [like e] ... at day09.Test05.main(Test05.java:25)
		} finally {
			System.out.println("always run");
		}
		
		System.out.println(num);
		System.out.println(res);
		
		System.out.println("End");
		
		//
	}

}
