package day10.ex;

import java.util.ArrayList;

public class BookController {
	
	private BookModel model;
	private BookView view;
	
	public BookController(BookModel model, BookView view) {
		this.model = model;
		this.view = view;
	}
	
	public void input() {
		String menu = "Input";
		// title is empty?
		String title = view.getTitle(menu);
		if(title != null) {
			// price is empty?
			int price = view.getPrice(menu);
			if(price != -1) {
				model.add(title,price);
			}
		}
	}
	
	// for Test
	public void input(Book data) {
		model.add(data);
	}

	public void edit() {
		String menu = "Edit";
		// searching keyword for edit is empty?
		String keyword = view.getTitle(menu);
		if(keyword != null) {
			// list of contains keywords is empty?
			ArrayList<Book> target = model.search(keyword);
			if(target.size()>0) {
				// selected book?
				String[] titles = model.getTitles(target);
				String title = view.selectTitle(titles, menu);
				if(title != null) {
					target = model.search(title);
					Book editBook = target.get(0);
					// title is empty?
					String editTitle = view.getTitle(menu);
					if(editTitle != null) {
						// price is empty?
						int editPrice = view.getPrice(menu);
						if(editPrice != -1) {
							editBook.setTitle(editTitle);
							editBook.setPrice(editPrice);
						}
					}
				}
			}
			else System.out.println("해당 단어가 포함된 책을 찾을 수 없습니다.");
		}
	}
	
	public void delete() {
		String menu = "Delete";
		// searching keyword for edit is empty?
		String keyword = view.getTitle(menu);
		if(keyword != null) {
			// list of contains keywords is empty?
			ArrayList<Book> target = model.search(keyword);
			if(target.size()>0) {
				// selected book?
				String[] titles = model.getTitles(target);
				String title = view.selectTitle(titles, menu);
				if(title != null) {
					target = model.search(title);
					// before delete, check y/n
					int check = view.check_Ok_Cancel(title + "을/를 삭제하시겠습니까?", menu);
					System.out.print("delete? size :");
					System.out.println(target.size());
					if(check == 0 && target.size() == 1) {
						model.deleteAll(target);
					}
				}
			}
			else System.out.println("해당 단어가 포함된 책을 찾을 수 없습니다.");
		}
	}
	
	public void search() {
		String menu = "Search";
		String keyword = view.getTitle(menu);
		if(keyword != null) {
			ArrayList<Book> result = model.search(keyword);
			model.printList(result);
		}
	}
	
	public void view() {
		model.printList();
	}
	
	public void run() {
		System.out.println("Run...");
		
		String[] menu = {
				" 1. Input",
				" 2. Edit",
				" 3. Delete",
				" 4. Search",
				" 5. View List",
				" 6. Exit"
		};
		
		while (true) {
			switch(view.menu(menu)) {
			case 1:
				this.input();
				break;
			case 2:
				this.edit();
				break;
			case 3:
				this.delete();
				break;
			case 4:
				this.search();
				break;
			case 5:
				this.view();
				break;
			case 6:
			case 0:
				System.out.println("End...");
				return;
			default:
			}
		}
	}
	// run in cmd, cms cls
//	private void clearScreen2() throws InterruptedException, IOException {
//		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//	}
	
}
