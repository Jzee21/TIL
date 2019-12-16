package day03;
/*
 * Week 01
 * 	day 03	(19. 12. 04)
 * 
 * 
*/

public class Test01 {

	public static void main(String[] args) {
		// == 와 equals() 메소드의 구분 사용 **
		// 기본형의 값 비교시	==
		// 객체의 비교시		equals()
		
		int i = 90, j = 90, k = 99;			// int i, j, k
		System.out.println(" i==j ? | i==k ? | i!=k ?");
		System.out.printf(" %6b | %6b | %6b\n",i==j, i==k, i!=k);
		
		System.out.println("======================");
		
		String s1 = new String("java"); 
		String s2 = new String("java");
		// s1, s2													
		System.out.printf("s1 = %s, s2 = %s\n", s1, s2);				// new 사용
		System.out.printf("s1 == s2 : %b\n",s1==s2);				//	false	// 주소의 비교	not 데이터
		System.out.printf("s1.equals(s2) : %b\n\n",s1.equals(s2));	//	true	// 주소의 데이터끼리 비교
		
		String s3 = "java";							// String class만 객체 생성 시 new를 사용하지 않아도 가능하다
		String s4 = "java";							// so, 기본형처럼 사용 가능
		// s3, s4
		System.out.printf("s3 = %s, s4 = %s\n", s3, s4);				// new X
		System.out.printf("s3 == s4 : %b\n",s3==s4);				//	true
		System.out.printf("s3.equals(s4) : %b\n\n",s3.equals(s4));	//	true
		// s1, s4
		System.out.printf("s1 = %s, s4 = %s\n", s1, s4);
		System.out.printf("s1 == s4 : %b\n",s1==s4);				//	false
		System.out.printf("s1.equals(s4) : %b\n\n",s1.equals(s4));	//	true
		
		
		
	}

}
