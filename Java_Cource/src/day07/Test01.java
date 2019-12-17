package day07;
/*
 * Week 02
 * 	day 07	(19. 12. 10)
 * 
 * 	��� Start.
 * 	Oh, Father.... fxxk
 * 
*/

public class Test01 {

	public static void main(String[] args) {
		/*
		 * 
		*/
//		Animal a = new Animal();
//		a.getClass();
		
		Dog d = new Dog();
		d.print();
		
		Dog d2 = new Dog("Maltese", "Beep-beep");
		d2.print();
		
		Animal d3 = new Dog();		// size cut down like Animal

		Dog d4 = (Dog) new Animal();
		
		//
	}

}
