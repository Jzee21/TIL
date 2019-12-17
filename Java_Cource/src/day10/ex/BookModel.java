package day10.ex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BookModel {
	
	private Set<Book> list;

	public BookModel() {
		this.list = new HashSet<Book>();
	}
	
	public void add(Book data) {
		this.list.add(data);
	}
	
	public void add(String title, int price) {
		this.list.add(new Book(title, price));
	}
	
	public void delete(Book data) {
		this.list.remove(data);
	}
	
	public void printList() {
		this.printList(this.list);
	}
	
	public void printList(Collection<Book> list) {
		int size = list.size();
		System.out.println("========= List =========");
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			data.print();
		}
		System.out.printf("총 권수 : %d\n", size);
		System.out.println("========================");
	}
	
	public String[] getTitles() {
		return this.getTitles(this.list);
	}
	
	public String[] getTitles(String msg) {
		return this.getTitles(this.search(msg));
	}
	
	public String[] getTitles(Collection<Book> target) {
		int size = target.size();
		String[] list = new String[size];
		Iterator<Book> it = target.iterator();
		for (int i = 0; i < size; i++) {
			Book data = (Book)it.next();
			list[i] = data.getTitle();
		}
		
		return list;
	}
	
	public ArrayList<Book> search(String msg) {
		ArrayList<Book> list = new ArrayList<Book>();
		Iterator<Book> it = this.list.iterator();
		while (it.hasNext()) {
			Book data = (Book)it.next();
			if(data.getTitle().toLowerCase().contains(msg.toLowerCase())) {
				list.add(data);
			}
		}
		return list;
	}
	
	public ArrayList<Book> searchAll() {
		return this.search("");
	}
	
	public void deleteAll(Collection<Book> list) {
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = (Book) it.next();
			this.list.remove(data);
		}
		
	}
	
//	ArrayList<String> getTitles()
//	public ArrayList<String> getTitles() {
//		return this.getTitles(this.list);
//	}
//	
//	public ArrayList<String> getTitles(String msg) {
//		return this.getTitles(this.search(msg));
//	}
//	
//	public ArrayList<String> getTitles(Collection<Book> target) {
//		ArrayList<String> list = new ArrayList<String>();
//		Iterator<Book> it = target.iterator();
//		while (it.hasNext()) {
//			Book data = (Book)it.next();
//				list.add(data.getTitle());
//		}
//		return list;
//	}
}
