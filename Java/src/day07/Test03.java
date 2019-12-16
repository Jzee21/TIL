package day07;
/*
 * Week 02
 * 	day 07	(19. 12. 10)
 * 
*/

public class Test03 {

	public static void main(String[] args) {
		/*
		 * super()
		*/
		
		Dog d1 = new Dog();
		d1.print();
		
		Dog d2 = new Dog("진돗개", "캐리");
		d2.print();
		
		Dog d3 = new Dog("시바견", "시바");
		d3.print();
		
		// not class
		// Just by me
		// do Test05
		System.out.println("== list test ===");
		
		Animal[] list = new Animal[10];
		int index = 0;
		
		list[0] = d1;
		list[1] = d2;
		list[2] = d3;
		
		Fish f1 = new Fish();
		Fish f2 = new Fish("니모");
		Fish f3 = new Fish("아기");
		
		list[3] = f1;
		list[4] = f2;
		list[5] = f3;
		
		index = 6;
		
		System.out.println("=== instanceof print ===");
		for (int i = 0; i < index; i++) {
			if (list[i] instanceof Dog) {
				((Dog)list[i]).print();
			}
			else if (list[i] instanceof Fish) {
				((Fish)list[i]).print();
			}
		}
		
		// in Test04
		System.out.println("=== list[i].breath ===");
		for (int i = 0; i < index; i++) {
			list[i].breath();
		}
		
		
		//
	}

}
