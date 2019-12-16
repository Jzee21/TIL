package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test02 {

	public static void main(String[] args) {
		/*
		 * SingleTone
		*/
		
		SingleTone s1 = SingleTone.getInstance();
		SingleTone s2 = SingleTone.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		//
	}
}


class SingleTone {
	
	private static SingleTone s;
	
	private SingleTone() {
		// SingleTone 클래스 안에서만 생성자 실행 가능 (private)
	}
	
	/**
	 * 	[ 중복 생성 방지. 오직 하나만이 존재하는 유일한 객체 ]
	 * @return	SingleTone s
	 */
	public static SingleTone getInstance() {
		if(s == null)
			s = new SingleTone();
		return s;
	}
	
}