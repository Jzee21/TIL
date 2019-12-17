package day10;
/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 	Generic
		*/
//		Employee2<String, String> emp1 = 
//				new Employee2<String, String>("홍길동", "2019001");
		// Error, <T, K**>, K : only Number Type
		Employee2<String, Integer> emp2 = 
				new Employee2<String, Integer>("김길동", 2019002);
		Employee2<String, Double> emp3 =
				new Employee2<String, Double>("이길동", 2019003.0);
//		Employee2 emp4 =
//				new Employee2("나길동", 2019003);
		
//		System.out.println(emp1);
		System.out.println(emp2.number/1000);
		System.out.println(emp3.number/1000);
//		System.out.println(emp4.number.getClass());
		
		//
	}

}

//				T : Object
//				   K : Object of Number
class Employee2<T, K extends Number> {
	T name;
	K number;
	
	public Employee2(T name, K number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", number=" + number + "]";
	}
	
}