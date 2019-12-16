package porb;

public class Prob06_BookApp {

	public static void main(String[] args) {
		/*
		 * Week 02 day 06 (19. 12. 09)
		 * 
		 * 	run BookMgr ( management Book class by List )
		 * 
		 */
		
		BookMgr mgr = new BookMgr();
		mgr.addBook(new Book("Java Program", 10000));
		mgr.addBook(new Book("JSP Program", 20000));
		mgr.addBook(new Book("SQL Fundamentals", 15000));
		mgr.addBook(new Book("JDBC Program", 30000));
		mgr.addBook(new Book("EJB Program", 26000));
		mgr.addBook(new Book("Raspberry Pi", 17000));
		mgr.addBook(new Book("GPIO Programing", 12000));
		mgr.addBook(new Book());
		// default name : ""
		// default price : 0
		// in BookMgr, ("", 0) do not add in BookMgr's List.
		
		mgr.printBookList();
		mgr.printTotalPrice();
		
		//
	}

}