package porb;

public class Prob08_TestShape {

	public static void main(String[] args) {
		Prob08_Shape[] shape = new Prob08_Shape[2];

		shape[0] = new Prob08_Circle("원", 10);
		shape[1] = new Prob08_Rectangle("직사각형", 10, 20);

		for (int i = 0; i < shape.length; i++) {
			shape[i].calculationArea();
			shape[i].print();
		}

		System.out.println("=== test ===");
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println("c.x = " + c.x);
		c.method();
		
		System.out.println("=== test2 ===");
		
		Child08 c8 = new Child08();
		System.out.println("x="+ c8.getX());

	}

}

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;

	void method() {
		System.out.println("Child Method");
	}
}

class Parent08 {
	int x = 100;

	Parent08() {
		this(200);
	}

	Parent08(int x) {
		this.x = x;
	}

	int getX() {
		return x;
	}
}

class Child08 extends Parent08 {
	int x = 3000;

	Child08() {
		this(1000);
	}

	Child08(int x) {
		this.x = x;
	}
}
