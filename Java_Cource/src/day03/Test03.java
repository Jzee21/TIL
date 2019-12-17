package day03;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * Scanner
		 * 		.nextLine()
		 * 		.nextInt()
		 * 		.close()		Garbage Control
		*/		
		System.out.println("======================");

		int korScore = 0;
		int mathScore = 0;
		String name = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("너의 이름은?");
		name = sc.nextLine();									// nextLine()
//		name = "A";
		System.out.printf("ok, 너의 이름은 %s다\n", name);
		
		System.out.println();
		System.out.println("너의 국어점수는?");
		korScore = Integer.parseInt(sc.nextLine());				// nextLine()
//		korScore = 75;
		System.out.printf("ok, 너의 점수는 %d다", korScore);
		System.out.printf(" : %s\n", 
				(korScore >= 0 && korScore <=100) ? 
						((korScore >= 80) ? "합격이다" : "불합격이다") : "이상하다" );
		
		System.out.println();
		System.out.println("너의 수학점수는?");
//		mathScore = Integer.parseInt(sc.nextLine()); 
		mathScore = sc.nextInt();								// nextInt()	**
		sc.hasNextLine();										// nextInt()로 int 받은 후 enter값이 남는것을 지우는 역할
//		mathScore = 90;
		System.out.printf("ok, 너의 수학점수는 %d다", mathScore);
		System.out.printf(" : %s\n", 
				(mathScore >= 0 && mathScore <=100) ? 
						((mathScore >= 80) ? "합격이다" : "불합격이다") : "이상하다" );
		
		System.out.println();
		double avg = (korScore+mathScore)/2;
		System.out.printf("So, 너의 중간고사는 %s다\n", ( avg >= 80 ? "pass" : "non pass" ) );
		
		
		
		
		
		System.out.println("======================");
		//
//		sc = null;		// line 14, error		// 위치에 따라 java.lang.NullPointException
		sc.close();		// line 14, no error
		return;			//	이걸 갑자기?
		
	}

}
