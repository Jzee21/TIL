package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

import day07.Animal;

public class Test01 {

	public static void main(String[] args) {
		/*
		 * 	Access Modifier
		 * 		(import day07.Animal)
		*/
		
		Animal a = new Animal();
//		System.out.println(a.kind);		// Error. 
		
		//
	}

}

class Dog2 extends Animal {
	public void print() {
		System.out.println(super.kind);		// No Error. super.kind : protected
	}
}

//	public class Animal {
//	
//		protected** String kind;
//	
//		public Animal ()
//		public Animal (String kind)
//
//		public void breath ()
//	}