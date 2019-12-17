package day07;
/*
 * Week 02
 * 	day 07	(19. 12. 10)
 * 
*/

public class Test02 {

	public static void main(String[] args) {
		/*
		 * Up Casting, Down Casting
		*/
		
		Object a = new Animal();
		((Animal)a).breath();			// Down Casting.
		
		Animal a2 = new Animal();
		a2.breath();
		
		Object obj = a2;
		
//		Animal temp = obj;				// Error
		Animal temp = (Animal)obj;		// Possible. Down Casting.
		temp.breath();
		
		
		System.out.println("=== breading ===");
//		Object d = new Dog();
//		Animal d2 = new Dog();
//		Dog d3 = new Dog();
		
		Dog d = new Dog("mal?","mal!");
		System.out.println(d.kind);
		
		Object obj2 = d;
		Animal a3 = (Animal)obj2;
		Dog d3 = (Dog)obj2;
		
		System.out.println(a3.kind);
		System.out.println(d3.kind);
		
		
		System.out.println("=== Hello Java? No@! ===");
		String msg = "Hello Java";
		Object obj7;
//		obj7 = a;		// a : Animal		// if 2. kind of Animal
//		obj7 = d;		// d : Dog("", "")	// if 1. mal?
											// if 2. Dog
		obj7 = msg;		// msg : String		// if 3. HELLO JAVA
		
		System.out.println(((Animal)a).kind);
		
		System.out.println("if 1.");
		if (obj7 instanceof Dog) {
			System.out.println(((Dog)obj7).kind);		// Error. cannot be cast to Dog
		}
		
		System.out.println("if 2.");
		if (obj7 instanceof Animal)
			System.out.println(((Animal)obj7).kind);		// Error. cannot be cast to Dog
		
		System.out.println("if 3.");
		if (obj7 instanceof String)
			System.out.println(((String)obj7).toUpperCase());		// Error. cannot be cast to Dog
		
		
		//
		System.out.println("===  My  ===");
		Animal myA1 = new Dog("My", "Dog");
		System.out.println(((Dog)myA1).kind);
		System.out.println(((Dog)myA1).name);
		System.out.println(((Dog)myA1).getClass());
		
		Object myA2 = new Dog("My", "Dog");
		System.out.println(((Dog)myA2).kind);
		System.out.println(((Dog)myA2).name);
		System.out.println(((Dog)myA2).getClass());
		
		System.out.println("===  My2  ===");
//		Dog myD1 = (Dog) new Object();			// Error. Object cannot be cast to Dog
//		System.out.println(myD1.kind);
//		System.out.println(myD1.name);
		
//		Dog myD2 = (Dog) new Animal();			// Error. Animal cannot be cast to Dog
//		System.out.println(myD2.kind);
//		System.out.println(myD2.name);
		
	}

}
