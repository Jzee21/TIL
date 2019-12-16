package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test06 {

	public static void main(String[] args) {
		/*
		 * 	HashSet with Book, BookMgr
		*/
		Set<Book> booklist = new HashSet<Book>();

		// add
//		booklist.add(new Book("Java", 500));
		if(booklist.add(new Book("Java", 500)))
			System.out.println("=== add success");
		else
			System.out.println("=== add fail");
		
		booklist.add(new Book("SQL", 1500));
		booklist.add(new Book("JSP", 5500));
//		booklist.add(new Book("Java", 500));
		if(booklist.add(new Book("Java", 500)))
			System.out.println("=== add success");
		else
			System.out.println("=== add fail");
		booklist.add(new Book("Hadoop", 1500));
		booklist.add(new Book("Spring", 6500));

		Iterator<Book> it = booklist.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			System.out.println(data);
		}

		// search
		System.out.println("===== search =====");
		String key = JOptionPane.showInputDialog("Enter the Title for Search", "Search");
		it = booklist.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if(book.title.toLowerCase().contains(key.toLowerCase())) {
				System.out.println(book);
			}
		}

		// delete
		System.out.println("===== delete =====");
		System.out.println("Enter the Title for Search");
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine().trim();
		it = booklist.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			if (data.title.contains(msg)) {
				System.out.println(data);
				System.out.println("Delete this book? (y/n)");
//				String bool = sc.nextLine().trim();
				if (sc.nextLine().trim().toLowerCase().equals("y"))
					it.remove();
			}
		}

		System.out.println("===== result =====");
		it = booklist.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			System.out.println(data);
		}

		// edit
		System.out.println("===== edit =====");
		System.out.println("Enter the Title for Search");
		msg = sc.nextLine().trim();
		it = booklist.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			if (data.title.contains(msg)) {
				
				if(data.title.contains(msg)) {
					data.title = data.title+"___";
				}
			}
		}

		System.out.println("===== result =====");
		it = booklist.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			System.out.println(data);
		}

		sc.close();
		sc = null;
		//
	}

}

class Book {
	String title;
	int price;

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}