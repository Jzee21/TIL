package porb;

public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("", 0);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 	if, Person has print()...
	 * 		go to Prob06, line 36.
	 */
	public void print() {
		System.out.printf("이   름 : %-4s   나   이 : %2d   ",
				this.name, this.age);
	}
	
}
