package porb;

public abstract class Prob08_Shape {

	private String name;
	private double area;
	
	public Prob08_Shape() {
		super();
	}

	public Prob08_Shape(String name) {
		super();
		this.name = name;
	}
	
	abstract void calculationArea();
	
	public void print() {
		System.out.printf("[%s 's area : %f]\n", this.name, this.area);
	}

	// getter
	public String getName() {
		return name;
	}

	public double getArea() {
		return area;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setArea(double area) {
		this.area = area;
	}
	

}
