package day06;
/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/

public class AccountTest2 {

	public static void main(String[] args) {
		/*
		 * 	Account Test 2
		 * 	생성자
		*/
		
//		Account a1 = new Account();
//		a1.setNumber("2019-12-09-0001");
//		a1.setName("홍길동");
//		a1.setBalance(10);
		
		Account a1 = new Account("2019-12-09-0001", "홍길동", 10);
		a1.print();
		
//		Account a2 = new Account();
//		a2.setNumber("2019-12-09-0091");
//		a2.setName("고길동");
//		a2.setBalance(7000);
		
		Account a2 = new Account("2019-12-09-0091", "고길동", 7000);
		a2.print();
		
		Account a3 = new Account();
		a3.print();
		
		System.out.println();
		
		
		
		
		
		//
	}

}
