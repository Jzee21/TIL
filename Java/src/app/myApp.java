package app;

import java.util.Scanner;

public class myApp {

//	private static Scanner sc;

	public static void main(String[] args) {

//		int menu = 0;
		String cmd = "";
		String check = "a";
		Scanner sc = new Scanner(System.in);
		
		

//		E: while (true) {
		while (true) {
			System.out.println("[ Enter the numnber you want. ]");
			System.out.println(" 1. Input");
			System.out.println(" 2. Edit");
			System.out.println(" 3. Delete");
			System.out.println(" 4. Search");
			System.out.println(" 5. View List");
			System.out.println(" 9. Exit");

			System.out.print(">> ");
//			menu = sc.nextInt();
//			sc.nextLine();
			cmd = sc.nextLine().trim();

			switch (cmd) {	// cmd or menu
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "9":
				System.out.print("\nDo you want to Exit? (y,n) >> ");
				check = sc.nextLine().toUpperCase();	// toUpperCase()를 사용 안하고
				if (check.equals("Y")) {				// check.equalsIgnoreCase("Y")로 대소문자 구분 없이 비교 가능
					System.out.println("\nBye bye~");
					sc.close();
					sc = null;
					return;								// End Main!! *******
//					break E;
				} else {
					System.out.println();
					break;
				}
			default:
				System.out.println("No Menu. Try again.");

			}
			// switch

//			menu = 0;
		}
		// while

//		sc.close();
//		sc = null;

	}
	// main

}
