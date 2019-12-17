package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import day06.ex.Book;

public class Test08 {

	public static void main(String[] args) {
		/*
		 * 	Test07 copy
		 * 	another try-catch type	(436p)
		*/
	
		System.out.println("Start");
		//
		
		// try (member) -> member 내부에 대해서는 finally에서 처리해주지 않아도 자동 처리됨
		try ( Scanner sc = new Scanner(new File("bookdata.txt"));	// <-
				){
			
			while (sc.hasNextLine()) {
				
				String[] data = sc.nextLine().split(" ");
				Book book = new Book(data[0], Integer.parseInt(data[1]));
				System.out.println(book);
//				book.print();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			// try 매개변수에서 자동 관리
//			if (sc != null) {
//				sc.close();
//				sc = null;
//			}
		}
		
		//
		System.out.println("End");

	}

}
