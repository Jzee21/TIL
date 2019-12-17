package day07;

public class Dog extends Animal {
	
	String kind = "kind of Dog";
	String name;
	
	public Dog () {
		super("Dog");
	}
	
	public Dog (String kind, String name) {
		super("Dog");
//		super.kind = "Dog";
		this.kind = kind;
		this.name = name;
	}
	
	//
	public void print () {
		System.out.printf("[%s] %s : %s\n",
				super.kind, this.kind, this.name);
	}
	
	public String getSuperKind() {
		return super.kind;
	}
	
}
