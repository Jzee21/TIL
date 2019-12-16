package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class AnimalTest {

	public static void main(String[] args) {
		/*
		 * day08.Animal
		 * 		 Dog
		 * 		 Fish
		*/
		
		Animal[] animals = {
			new Dog("진돗개", "멍멍이"),	
			new Fish("아기상어")	
		};
		
		for (Animal data :animals) {
			data.breath();
		}
		
		
		//
	}

}
