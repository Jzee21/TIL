package porb;

public class Prob01 {
	public static void main(String[] args) {
		
		/*
		 * Week 01
		 * 	day 02	(19. 12. 03)
		 * 
		 * 
		*/
		
		/*
		 * 01.
			 아래는 변수 num의 값에따라  양수 음수  0을 출력하는  코드이다.
			삼항 연산자를 이용해서 에 알맞은 코드를 완성하세요. 
			힌트:   삼항 연산자를 두번 이용   
		*/
		int num = -90;
		System.out.println( num > 0 ? "양수" : ( num < 0 ? "음수" : 0 ) );
	
	
		/*
		 * 02.
		        다음은 대문자를 소문자로 변경하는 코드입니다.
		        변수 ch에 저장된 문자가 대문자 인 경우에만 
			소문자로 변경하는 코드를 완성 합니다.
	  	*/
		char ch = 'P';
		char lowerCase = ( ('A' <= ch && ch <= 'Z') ? (char)(ch+32) : ch );
		System.out.print("ch: " + ch);
		System.out.println(" to lowerCase :"+lowerCase);
		System.out.printf("ch: %2c to lowerCase : %2c\n", ch, lowerCase);
		
		System.out.println("======================");
		
		
		// Prob sub2.
//		System.out.println('1'+'2');	// 99	
////		System.out.println((int)'1');	// 49
//		System.out.println("1"+"2");
//		System.out.println("~~ "+1+2);
//		System.out.println(1+2+"~~");
//		System.out.println("Hello"+"java"+'!');
		
		// Prob sub3.		
//		  a. $ystem			o 
//		  b. num#5 			x
//		  c. 7num			x
//		  d. 자바				o				
//		  e. new 			x
//		  f. new_ 			o
//		  g. $MAX_NUM  		o
//		  h. hello@com		x 		
		
		// Prob sub4.
//		  a. byte b = 256;
//		  b. char c = ''; 
//		  c. char answer = 'no';
//		  d. float f = 3.14;
//		  e. double d = 1.4e3f;
		
		// Prob sub5.
//		int x = 2;
//		int y = 5;
//		char cc = 'A'; // 'A' 65 
//		System.out.println(y >= 5 || x < 0 && x > 2);     
//		System.out.println( !('A' <= cc && cc <='Z') );     
//		System.out.println('C'-cc);                        
//		System.out.println('5'-'0');                      
//		System.out.println(cc+1);                         
//		System.out.println(++cc);                          
//		System.out.println(cc++);                          
//		System.out.println(cc); 
		
	}
}