package day03;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) throws Exception {
		/*
		 * Test04 응용
		 * 
		 * System.In -> FileInputStream
		 * 
		 */
		System.out.println("======================");
		
		System.out.println("App start...");
		String studentName;
		int kor, eng, math;
		kor = eng = math = 0;
//		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner( new FileInputStream("C://workspace/lib/score.txt") );
		
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
		System.out.println("enter your name and score. (Name, Korean, English, Math)");
		System.out.println("ex] Name 90 90 90");
		System.out.print(">> ");

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
		if ( avg >= 90 ) {
			grade = 'A';
		} else if ( avg >= 80 ) {
			grade = 'B';
		} else if ( avg >= 70 ) {
			grade = 'C';
		} else if ( avg >= 60 ) {
			grade = 'D';
		} else {
			grade = 'F';
		} 
		
		System.out.println();
		System.out.printf("[ Name : %s ]\n", studentName);
		System.out.printf("| %8s | %8s | %8s |\n", "Korean", "English", "Math" );
		System.out.printf("| %8d | %8d | %8d |\n", kor, eng, math );
		System.out.printf("| %8s | %8.2f | %7s |\n", "Avg", avg, (avg > 80) ? "합격" : "불합격" );		// 26
		System.out.printf("|    Grade | %19c |\n", grade );
				
		System.out.println("======================");
		
		/*
		 * if 문
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
