package day02;

public class Test03 {

	public static void main(String[] args) {
		
		// text lentgh
		int pw = 0;
//		pw = "dddd".length();		// Java 상위 버전에서는 함수형을 지원하면서 사용 가능
		System.out.println(pw);
		
		pw = "hello".length();		
		System.out.println(pw);
		System.out.println(pw>8);
		System.out.println("======================");
		
		pw = "hello   w~".trim().length();			// trim : delete space		
		System.out.println(pw);
		System.out.println(pw>8);
		System.out.println("======================");
		
		pw = "hello   w~".trim().toUpperCase().length();		
		System.out.println(pw);
		
		// String text
		System.out.println("\n======================");
		System.out.println("========String========");
		System.out.println("======================");
		
		String msg = null;
		System.out.println(msg);
		msg = "null to ~~~~~~~~~~~~~";
		System.out.println(msg);
		System.out.println("======================");
		
		String msg2 = msg = "What?!";
		System.out.println(msg);
		System.out.println(msg2);
		
		msg2 = msg = null;		// clear
		
		
		
	}

}
