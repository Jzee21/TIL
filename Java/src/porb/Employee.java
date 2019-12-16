package porb;

public class Employee extends Person {

	private String dept;

	public Employee() {
		super();
	}
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * 	print()
	 */
	@ Override
	public void print() {
		super.print();
		System.out.printf("부     서 : %s\n", this.dept);
	}
	
}
