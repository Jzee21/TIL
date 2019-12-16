package porb;

public class Prob08_Circle extends Prob08_Shape {

	private double radius;
	
	public Prob08_Circle() {
		super();
	}

	public Prob08_Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	@Override
	void calculationArea() {
		super.setArea(Math.PI*radius*radius);
	}
	
	public void print() {
		System.out.printf("%s의 면적은 %f\n", super.getName(), super.getArea());
	}

	// getter
	public double getRadius() {
		return radius;
	}

	// setter
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}
