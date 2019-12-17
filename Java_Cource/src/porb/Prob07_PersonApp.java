package porb;
/*
*/
public class Prob07_PersonApp {

	public static void main(String[] args) {
		/*
		 * Week 02 day 07 (19. 12. 10)
		 *
		 * 	Using files
		 * 		Person.java
		 * 		Student.java
		 * 		Teacher.java
		 * 		Employee.java
		 * 
		 */
		
		Person[] list = new Person[3];
		
		list[0] = new Student("홍길동", 20, 200201);
		list[1] = new Teacher("이순신", 30, "Java");
		list[2] = new Employee("유관순", 40, "교무과");
		
//		Person[] list2 = {
//				new Student("홍길동", 20, 200201),
//				new Teacher("이순신", 30, "Java"),
//				new Employee("유관순", 40, "교무과")	
//		};
		
		System.out.println("=== Down Casting ===");
		for (Person data :list) {
			if (data instanceof Student)
				((Student)data).print();
			else if (data instanceof Teacher)
				((Teacher)data).print();
			else if (data instanceof Employee)
				((Employee)data).print();
		}
		
		/**
		 *  if, print() has Person,
		 */
		System.out.println("=== data.print() ===");
		for (Person data :list) {
			data.print();
		}
		
		//
	}
	
}
