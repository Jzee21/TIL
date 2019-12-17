package porb;

public class Prob08_Rectangle extends Prob08_Shape {

	private double width;
	private double hight;
	
	public Prob08_Rectangle() {
		super();
	}

	public Prob08_Rectangle(String name, double width, double hight) {
		super(name);
		this.width = width;
		this.hight = hight;
	}

	@Override
	void calculationArea() {
		super.setArea(this.width*this.hight);
	}

	public void print() {
		System.out.printf("%s의 면적은 %.1f\n", super.getName(), super.getArea());
	}

	// getter
	public double getWidth() {
		return width;
	}

	public double getHight() {
		return hight;
	}

	// setter
	public void setWidth(double width) {
		this.width = width;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}
	
}
