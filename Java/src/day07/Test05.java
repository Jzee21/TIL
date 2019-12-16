package day07;
/*
 * Week 02
 * 	day 07	(19. 12. 10)
 * 
*/

public class Test05 {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
		Dog[] dList;
		Fish[] fList;
		Animal[] animals = {
				new Dog("진돗개", "캐리"),
				new Fish("니모"),
				new Dog("시바견", "시바"),
				new Fish("아기상어")
		};
		
		for (Animal data : animals) {
			if (data instanceof Dog)
				((Dog)data).print();
			else if (data instanceof Fish)
				((Fish)data).print();
			data.breath();
		}
		
		
		//
	}

}
