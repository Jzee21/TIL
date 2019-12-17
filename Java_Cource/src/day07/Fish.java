package day07;

public class Fish extends Animal {

//	String kind;
	String name;
	
	public Fish () {
		super("Fish");
	}
	
	public Fish (String name) {
		super("Fish");
//		this.kind = kind;
		this.name = name;
	}

	@Override		// Java Annotation**
	public void breath () {
//		super.breath();
		System.out.println("아가미...");
	}
	
	public void print() {
		System.out.printf("[%s] %s\n",
				super.kind, this.name);
	}
	
}
