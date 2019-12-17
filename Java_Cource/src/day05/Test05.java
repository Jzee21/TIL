package day05;

public class Test05 {

	public static void main(String[] args) {
		/*
		 * 	클래스와 객체
		 * 
		 * 	Employee
		 */
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		emp1.name = "Mr. Hong";
		emp1.dept = "Tech.";
		emp1.age = 32;
		
		emp2.name = "Mr. Ko";
		emp2.dept = "Edu.";
		emp2.age = 29;
		
		Employee emp3 = emp1;			// Do not use like this.
		emp3.age = 35;
		
		emp1.print();
		emp2.print();
		emp3.print();					// That's why U can see here.
		
		
//		Employee[] employees = new Employee[100];
		
		//
	}

}

// public class
// non public class	: U can use this class at other Package
class Employee {
	String name;
	String dept;
	int age;
	
	public void print() {
		System.out.printf(
				"[ %10s | %10s | %3d ]\n", this.name, this.dept, this.age);
	}

}