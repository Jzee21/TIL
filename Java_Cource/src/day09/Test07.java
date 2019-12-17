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

public class Test07 {

	public static void main(String[] args) {
		/*
		 * 	Exception Handling
		 * 			( Memory _ GC )
		*/
	
		System.out.println("Start");
		//
		
		Scanner sc = null;
		try {
			sc = new Scanner(new File("bookdata.txt"));
			// 파일이 없을 때 에러 발생 가능
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(" ");
				Book book = new Book(data[0], Integer.parseInt(data[1]));
//				System.out.println(book);
				book.print();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();		// 파일이 없거나 생성되어도 잘못될 경우 메모리 반환을 강제
				sc = null;
			}
		}
		
		//
		System.out.println("End");

	}

}
