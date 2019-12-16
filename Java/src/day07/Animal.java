package day07;

public class Animal {
	
	protected String kind = "kind of Amimal";
	
	public Animal () {
		super();
	}
	
	public Animal (String kind) {
		super();
		this.kind = kind;
	}
	
	// -------------- // 선언부
	public void breath () {
		/*
		 * 구현부
		 */
		System.out.println("폐...");
	}
}
