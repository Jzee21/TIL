package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test03 {

	public static void main(String[] args) {
		/*
		 * class has a 관계
		*/
		
		//
	}

}

class Point {
	int x;
	int y;
	
	public void print() {
		
	}
}

// Has a 관계
class Circle2 {
	Point p;		// **
	int r;
}

class Circle3 extends Point {	// 요상... -> Circle2 추천
//	int x;
//	int y;
	int r;
}