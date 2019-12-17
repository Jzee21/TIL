package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import day06.ex.Book;

public class Test08_my {

	public static void main(String[] args) {
		/*
		 * 	Test08 copy
		 * 	in while, use StringTokenizer
		 *  	StringTokenizer dose not implements java.lang.AutoCloseable**
		 *  	so, StringTokenizer* can't enter try( here* )
		*/
	
		System.out.println("Start");
		//
		StringTokenizer st;
		
		try ( Scanner sc = new Scanner(new File("bookdata.txt")); ){
			
			while (sc.hasNextLine()) {
				
				st = new StringTokenizer(sc.nextLine());
				Book book = new Book(st.nextToken(), Integer.parseInt(st.nextToken()));
				System.out.println(book);
//				book.print();
				st = null;
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
