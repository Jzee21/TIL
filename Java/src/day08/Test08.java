package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test08 {

	public static void main(String[] args) {
		/*
		 * 	interface 통합?
		*/
		Drawable[] list = {
				new Circle(),
				new Rectangle()
				};
		
		for (Drawable data :list) {
			data.draw();
			((Moveable)data).move();
		}
		
		System.out.println("== interface 에서의 다중상속 ==");
		T[] listT = {
				new Circle(),
				new Rectangle()
				};
		
		for (T data :listT) {
			data.draw();
			data.move();
		}
		
		
		//
	}

}

interface Drawable {
	void draw();
}

interface Moveable {
	void move();
}

// Today Key Point! ******************************************
interface T extends Drawable, Moveable {
	
}

class Circle implements T {
	String name = "Circle";

	@Override
	public void move() {
		System.out.println(name + " 이동");
	}

	@Override
	public void draw() {
		System.out.println(name + " 그리기");
	}
	
}

class Rectangle implements T {
	String name = "Ractangle";

	@Override
	public void move() {
		System.out.println(name + " 이동");
	}

	@Override
	public void draw() {
		System.out.println(name + " 그리기");
	}
	
}