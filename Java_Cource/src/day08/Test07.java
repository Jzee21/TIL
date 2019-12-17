package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test07 {

	public static void main(String[] args) {
		/*
		 * 	compare 'Abstract Class', 'Interface'
		*/
		
		Circle_a a = new Circle_a();
		System.out.println(a.cArea(5));
		a.print();
		a.color = "purple";
		System.out.println(a.color);
		
		Circle_i i = new Circle_i();
		System.out.println(i.cArea(5));
//		i.color = "purple";					//	Error : final static
		System.out.println(i.color);
		
		//
	}

}

// abstract class (추상메서드)
abstract class Shape_a {
	String color;
	public abstract double cArea(double r);
	public void print() { }
	
}

// interface (인터페이스)
interface Shape_i {
	final static String color = "Red";			// 고정값의 final valuable
	public abstract double cArea(double r);
	public void print();
	
}

// abstract class
class Circle_a extends Shape_a {
	int r;

	@Override
	public double cArea(double r) {
		return Math.PI * r * r;
	}
}

// interface class
class Circle_i extends Object implements Shape_i {

	@Override
	public double cArea(double r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}