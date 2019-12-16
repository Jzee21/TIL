package day07;
/*
 * Week 02
 * 	day 07	(19. 12. 10)
 * 
*/

public class Test04 {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
//		Fish f = new Fish("니모");
//		f.print();
		
		Animal f = new Fish("니모");
		((Fish)f).print();
		
		System.out.println(f.kind);
		System.out.println(((Fish)f).kind);
		
		f.breath();				// 둘의 실행결과 동일
		((Fish)f).breath();		// Fish.breath() 실행
		
		
		//
	}

}
