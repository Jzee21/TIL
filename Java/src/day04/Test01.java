package day04;
/*
 * Week 01
 * 	day 04	(19. 12. 05)
 * 
 * 
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws Exception {
		/*
		 * day04.Test01
		 *
		 * Base day3.Test05
		 * 
		 * add Switch()
		 * 
		 */
		
		System.out.println("App start...");
		String studentName;
		int kor, eng, math;
		kor = eng = math = 0;
//		Scanner sc = new Scanner(System.in);
//		Scanner sc2 = new Scanner( new FileInputStream("C://workspace/lib/score.txt") );
		Scanner sc2 = new Scanner( new FileInputStream("C://workspace/lib/score.txt"), "UTF-8" );
				// new Scanner ( InputStream, String(encoding type )
		
		// before run, ask want to run
//		System.out.println("if you want to exit, enter the 'q'");
//		String msg = sc.nextLine().toLowerCase();
////		if ( msg.equals("q") || msg.equals("Q") ) {
//		if ( msg.equals("q") ) {	//	if ( msg.toLowerCase().equals("Quit".toLowerCase()))
//			if (sc != null ) {
//				sc.close();
//				sc = null;
//			}
//			System.out.println("bye bye!");
//			return ;				
//		}
		
		System.out.println();
		System.out.println("File Opend");
		System.out.println(">> ");

		// sc : System.in
//		studentName = sc.next();
//		kor = sc.nextInt();
//		eng = sc.nextInt();
//		math = sc.nextInt();		

		studentName = sc2.next();
		kor = sc2.nextInt();
		eng = sc2.nextInt();
		math = sc2.nextInt();
		sc2.nextLine();
		
		double sum = kor + eng + math;
		double avg = sum / 3;
		
		char grade = 'N';			// non Pass

//		if ( avg >= 90 ) {
//			grade = 'A';
//		} else if ( avg >= 80 ) {
//			grade = 'B';
//		} else if ( avg >= 70 ) {
//			grade = 'C';
//		} else if ( avg >= 60 ) {
//			grade = 'D';
//		} else {
//			grade = 'F';
//		} 

		
/*
 *	switch 문 
 */
		switch ( ((int)avg) / 10 ) {			// 매개변수는 int of String 이어야		// int, char, byte, 등
												// ah... 등급에 소수점은 필요 없지...!!
												// String is run in ver. 1.8~
		case 10 :			// 100 -> case 9
		case 9 :
			grade = 'A';
			break;
		case 8 :
			grade = 'B';
			break;
		case 7 :
			grade = 'C';
			break;
		case 6 :
			grade = 'D';
			break;
		default :
			grade = 'F';
			break;			// <<--	Lost break 생략 가능		
		
		}
		
		
		System.out.println();
		System.out.printf("[ Name : %s ]\n", studentName);
		System.out.printf("| %8s | %8s | %8s |\n", "Korean", "English", "Math" );
		System.out.printf("| %8d | %8d | %8d |\n", kor, eng, math );
		System.out.printf("| %8s | %8.2f | %7s |\n", "Avg", avg, (avg > 80) ? "합격" : "불합격" );		// 26
		System.out.printf("|    Grade | %19c |\n", grade );
		
		switch ( grade ) {
		case 'A' :
		case 'B' :									// A, B >> print "Excellent"
			System.out.println("Excellent!");
			break;
		case 'C' :
		case 'D' :									// C, D >> print "Good"
			System.out.println("Good!");
			break;
		case 'F' :
			System.out.println("Oh, no...!");
			break;
		case 'N' :
			System.out.println("Please reason this class");
			
		}
		
				
		System.out.println("======================");
		
/*
 *	if 문
*/
		// if , if
//		if ( avg >= 80 ) {
//			System.out.println("Pass!");
//		}
//		if ( avg < 80 ) {
//			System.out.println("Non Pass!");
//		}
		
//		// if , else if
//		if ( avg >= 80 ) {
//			System.out.println("Pass!");
//		} else if ( avg < 80) {
//			System.out.println("Non Pass!");			
//		}
		
		// if , else
		if ( avg >= 80 ) {
			System.out.println("Pass!");
		} else {
			System.out.println("Non Pass!");			
		}
		
		System.out.println("bye bye!");
		
//		sc.close();
//		sc = null;
		if ( sc2 != null ) sc2.close();
//		sc2.close();
		sc2 = null;
		return ;
		
	}

}
