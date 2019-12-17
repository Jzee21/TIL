package day06;
/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/

public class AccountTest {

	public static void main(String[] args) {
		/*
		 * 	Account Test
		*/
		
		Account a1 = new Account();
		a1.setNumber("2019-12-09-0001");
		a1.setName("홍길동");
		a1.setBalance(10);
		a1.print();
		
		Account a2 = new Account();
		a2.setNumber("2019-12-09-0091");
		a2.setName("고길동");
		a2.setBalance(7000);
		a2.print();
		System.out.println();
		
		a1.input(a2.output(2000));
		System.out.println();
		
//		a2.transfer(a2, a1, 2000);
		Account.transfer(a2, a1, 2000);
		System.out.println();
		
		a2.transfer(a1, 2000);
		
		
		
		
		//
	}

}
