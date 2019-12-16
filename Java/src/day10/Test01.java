package day10;
/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test01 {

	public static void main(String[] args) {
		/*
		 *	Generic 
		*/
//		Employee<String> emp1 = new Employee<String>("홍길동", "2019001");
		Employee<String> emp1 = 
				new Employee<String>("홍길동", "2019001");
		System.out.println(emp1);		// Employee [name=홍길동, number=2019001]
		System.out.println(emp1.number.charAt(3));
		System.out.println(emp1.number.getClass());
		
		//      <Object**>
		Employee<Integer> emp2 = 
				new Employee<Integer>("고길동", 2019002);
		System.out.println(emp2);		// Employee [name=고길동, number=2019003]
		System.out.println(emp2.number.getClass());

//		Employee emp3 = new Employee("김길동", 2019003);
//		System.out.println(emp3);		// Employee [name=김길동, number=2019003]
//		System.out.println(emp3.number.getClass());
		//					    number. -> Object's methods
		
		//
	}

}

// Generic	// T
class Employee<T> {
	String name;
	T number;		// 사원번호		// String? name? 결정 못함
									// T : Data Type
	
	public Employee(String name, T number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public T getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", number=" + number + "]";
	}
	
}