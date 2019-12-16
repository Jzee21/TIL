package porb;

public class Prob02 {

	public static void main(String[] args) throws Exception {
		/*
		 * Week 01 day 03 (19. 12. 04)
		 */
		
//		[*]
//		고전 암호학(Classical Cryptography)에서 사용하는 기법 중 
//		“Caesar Cipher” 는 
//		암호화의 대상이 되는 각각의 문자들을 알파벳 상의 
//		세번째 오른쪽 문자로 치환하는 간단한 치환 암호기법
//		(즉, a는 d로, b는 e로, … , x는 a로, y는 b로, z는 c로)입니다.  
//		“everyday we have is one more than we deserve” 라는 문자열에 대해 
//		Caesar Cipher 를 적용하여 암호화된 문자열 값을 아래와 같이 출력하도록 
//		Prob2의 클래스의 main 함수를 완성하십시오. 
//		(단, 공백에 대해서는 치환을 적용하지 않습니다.)
//
//		*****  실행시 출력예시 *****
//		암호화할 문자열 : everyday we have is one more than we deserve
//		암호화된 문자열 : hyhubgdb zh kdyh lv rqh pruh wkdq zh ghvhuyh

		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";
		String encodedString2 = "";
		
		StringBuilder sb = new StringBuilder();
		
		// 프로그램을 구현부 시작.
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다.
		long runStartTime = System.currentTimeMillis();
		for ( int i = 0 ; i < sourceString.length() ; i++ ) {
			char ch = sourceString.charAt(i);
			if ( 97 <= ch && ch <= 119 ) {
				ch = (char)(ch+3);
			} else if ( 120 <= ch && ch <= 122 ) {
				ch = (char)(ch-23);
			}
			Thread.sleep(50);
			encodedString += ch;
			sb.append(ch);
		}
		long runEndTime = System.currentTimeMillis();
		System.out.println((runEndTime - runStartTime)/1000.0);
		// 프로그램 구현부 끝.
		
		encodedString2 = sb.toString();

		
//		// char와 char 사이의 값 비교에서
//		// char를 int로 비교하는 것과 char와 비교하는 것의 처리속도 차이를 알고싶다
//		// ** 비교 결과 *****************************************
//		// char & char 비교에서도
//		// char의 int 형변환 후 비교가 이루어져 속도저하 확인
//		long runStartTime2 = System.currentTimeMillis();
//		for ( int i = 0 ; i < sourceString.length() ; i++ ) {
//			char ch = sourceString.charAt(i);
//			if ( 'a' <= ch && ch <= 'w' ) {
//				ch = (char)(ch+3);
//			} else if ( 'x' <= ch && ch <= 'z' ) {
//				ch = (char)(ch-23);
//			}
//			Thread.sleep(50);
//			encodedString += ch;
//		}
//		long runEndTime2 = System.currentTimeMillis();
//		System.out.println((runEndTime2 - runStartTime2)/1000.0);
//		System.out.println(((runEndTime-runStartTime) - (runEndTime2-runStartTime2))/1000.0);
		
		
		System.out.println("암호화할 문자열 : " + sourceString);
		System.out.println("암호화된 문자열 : " + encodedString);
		System.out.println("암호화된 문자열 : " + encodedString2);
		System.out.println("암호화된 문자열 : " + sb);
		
		
		// Sub Prob **
//		[1] int형 변수 year가 400으로 나눠떨어지거나 
//	    또는 4로 나눠떨어지고  
//	    100 나눠떨어지지 않을 때 인 조건식을 만들어 보세요(윤년공식).
//
		System.out.println("[ Prob sub 01 ]");
		int year = 1600;
		if ( year%4==0 && year%100!=0 || year%400==0 ) {
			System.out.println("윤년");
		} else {
			System.out.println("윤년 x");
		}

//		[2] 1부터 20까지의 정수 중에서 
//	    2또는 3의 배수가 아닌 수의 총합을 구해 보세요  .
//
//		public class Prob2 {
//			public static void main(String[] args) { 
//				int sum = 0; 
//				//ToDo
//				System.out.println("sum="+sum);  
//			}
//		}
		System.out.println("[ Prob sub 02 ]");
		int sum = 0;
		for ( int i=1 ; i<=20 ; i++ ) {
			if ( i%2 != 0 && i%3 != 0 ) {
				sum += i;
//				System.out.printf("%d ", i);
			}
		}
		System.out.println(sum);
	
//		[3]
//		1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 결과를 구해 보세요
		System.out.println("[ Prob sub 03 ]");
		int sum2 = 0;
		for ( int i=1 ; i<=10 ; i++ ) {
			for ( int j=1 ; j<=i ; j++ ) {
				sum2 += j;
			}
		}
		System.out.print("sum2 : ");
		System.out.println(sum2);
		
		
		

	}

}
