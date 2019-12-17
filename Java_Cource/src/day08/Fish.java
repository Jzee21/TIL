package day08;

public class Fish extends Animal {

	String name;
	
	public Fish () {
		super("Fish");
	}
	
	public Fish (String name) {
		super("Fish");
		this.name = name;
	}

	public void print() {
		System.out.printf("[%s] %s\n",
				super.kind, this.name);
	}
	
	@ Override
	public void breath () {
		System.out.println("아가미...");
	}
	
}
