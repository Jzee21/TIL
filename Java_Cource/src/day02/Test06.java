package day02;

public class Test06 {

	public static void main(String[] args) {
		// Chapter 3. Operator 	연산자
		
		// + - * / % ++ --
		int num = 99;
		num += 1;
		num = num + 1;
		System.out.println(num);			// 101
		System.out.println(num % 10);		// 1		// % : 나머지
		System.out.println(num / 10);		// 10
		System.out.println(num);			// 101
		System.out.println(num++);			// 101		// add after** use(print)
		System.out.println(num);			// 102
		System.out.println(++num);			// 103		// add before** use(print)
		System.out.println("======================");
		
		// > >= < <= == !=
		int point = 70;
		boolean flag = point >= 80;
		System.out.println("Point : " + point);
		System.out.println("Good? : " + (point >= 80) );	// false
		System.out.println("Good? : " + flag );				// false
		
		// && : and
		// &  : or
		flag = point >= 0 && point <= 100;
		System.out.println("Is it Point? : " + flag);
		System.out.println("======================");
		
		// Char ASCII
		System.out.printf("%c => %d\n", '0', (int)'0');		// 48
		System.out.printf("%c => %d\n", 'A', (int)'A');		// 65
		System.out.printf("%c => %d\n", 'a', (int)'a');		// 97
		
		// 소문자일 때, -32를 하면 대문자가 된다.
		char c = 'a';
		System.out.printf("Is it Number? : %b\n", Character.isDigit(c));	// false
		flag = '0' <= c && c <= '9';
		System.out.printf("Is it Number? : %b\n", flag);					// false
		flag = 'a' <= c && c <= 'z';
		System.out.printf("Is it Little char? : %b\n", flag);				// true
		System.out.printf("%c to %c\n", c, (char)(c-32));						// a to A
		System.out.println("======================");
		
		// 삼항연산자 	[ ~ ? 1 : 2; ]
		int score = 80;
		String result = "pass";
		result = "";
		result = ( score >= 70 ) ? "pass" : "retest";
		System.out.println(score + " : " + result);
		
		char ch = 'B';
		// small to big 	(only) ㄱ
		char r = ( ch >='a' && ch <= 'z' ) ? (char)(ch-32) : ch ;
		// (small to big) or (big to small) ㄱ
		char r2 = ( ch >='a' && ch <= 'z' ) ? (char)(ch-32) : ( ch >='A' && ch <= 'Z' ) ? (char)(ch+32) : 'E' ;
		System.out.println(ch + " : " + r);				// B : B
		System.out.println(ch + " : " + r2);			// B : b
		
		
	}

}
