package day06;

import javax.swing.JOptionPane;

/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/

public class AccountTest3 {

	public static void main(String[] args) {
		/*
		 * 	Account Test 3
		*/

//		Account[] accounts = new Account[5];
		Account[] accounts = {
				new Account("2019-12-09-0001", "홍길동", 10),
				new Account("2019-12-09-0091", "고길동", 7000),
				new Account("2019-12-09-0121", "나길동", 17000),
				new Account("2019-12-09-0831", "다길동", 3000),
				new Account("2019-12-09-1831", "라길동", 700),
				new Account("2019-12-09-6811", "마길동", 790000),
				new Account("2019-12-09-9421", "사길동", 7000)
		};
		
		System.out.println("Account List");
		for (Account a :accounts) {
			a.print();			
		}
		
		System.out.println();
		System.out.println("Account Search");
		String name = JOptionPane.showInputDialog("Please Enter the Name.");
		for (Account a :accounts) {
			if(a.getName().equalsIgnoreCase(name.trim()))
				a.print();			
		}
		
		
		//
	}

}
