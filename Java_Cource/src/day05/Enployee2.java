package day05;

public class Enployee2 {
	
	String name;
	String dept;
	int age;
	
	public void print() {
		System.out.printf(
				"[ %10s | %10s | %3d ]\n", this.name, this.dept, this.age);
	}
	
}
