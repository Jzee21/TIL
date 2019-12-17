package day10.ex;

import java.util.ArrayList;


public class BookApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookModel model = new BookModel();
		BookView view = new BookView();
		
		BookController mgr = new BookController(model, view);
		
		// for Test
		mgr.input(new Book("SQL", 22000));
		mgr.input(new Book("HTML5", 27000));
		mgr.input(new Book("Oracle del", 17000));
		mgr.input(new Book("JAVA", 22000));
		mgr.input(new Book("Python", 21000));
		mgr.input(new Book("Hadoop del", 20000));
		mgr.input(new Book("Network", 29000));
		
		mgr.run();
		
	}

}

