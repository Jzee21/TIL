package day06.ex;

import javax.swing.JOptionPane;

public class BookApp {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
//		BookMgr mgr = new BookMgr();	// list size = 10;
		BookMgr mgr = new BookMgr(3);	// list size = 3;
		
		Book book = new Book("Java", 33000);
		mgr.addBook(book);
//		mgr.addBook(new Book("Java", 33000));
		
		mgr.addBook(new Book("SQL", 22000));
		mgr.addBook(new Book("HTML5", 27000));
		mgr.addBook(new Book("Oracle", 17000));
		
		mgr.printBookList();
		mgr.printTotalPrise();
		
		mgr.printSearchTitle(JOptionPane.showInputDialog("검색할 도서를 입력하세요"));
		
		
		//
	}

}
