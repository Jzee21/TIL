package day06.ex;

//import java.util.Arrays;

public class BookMgr {
	
	private Book[] bookList;
	private int cnt = 0;
	
	public BookMgr() {
		bookList = new Book[10];
	}
	
	public BookMgr(int size) {
		bookList = new Book[size];
	}

	public void addBook (Book book) {
		if (cnt == this.bookList.length) {
			Book[] temp = new Book[bookList.length*2];
			System.arraycopy(bookList, 0, temp, 0, bookList.length);
			this.bookList = temp;
			temp = null;
		}
		bookList[cnt++] = book;
	}
	
	public void printBookList () {
		System.out.println("===== Book List =====");
		for (int i = 0; i < cnt ; i++) {
			bookList[i].print();
		}
	}
	
	public void printTotalPrise () {
		int sum = 0;
		for (int i = 0; i < cnt; i++) {
			sum += bookList[i].getPrice();
		}
		System.out.println("==== Total Prise ====");
		System.out.print("Total : ");
		System.out.println(sum);
	}

	public void printSearchTitle(String title) {
		System.out.println("==== Search Book ====");
		for (int i = 0 ; i<cnt ; i++) {
			if ( this.bookList[i].getTitle().toLowerCase().contains(title.toLowerCase()) ) {
				System.out.print("검색어 : ");
				System.out.println(title);
				this.bookList[i].print();
			}
		}
	}
	
}
