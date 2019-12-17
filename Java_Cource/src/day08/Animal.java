package day08;

public abstract class Animal {
	
	protected String kind = "kind of Amimal";
	
	public Animal () {
		super();
	}
	
	public Animal (String kind) {
		super();
		this.kind = kind;
	}
	
	public abstract void breath();
	
}
