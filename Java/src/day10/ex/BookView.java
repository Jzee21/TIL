package day10.ex;

import javax.swing.JOptionPane;

public class BookView {
	
	public BookView() {
		
	}
	
	/**
	 * menu()
	 * 
	 * input menu from Dialog
	 * if exit, check again
	 * 
	 * @return
	 */
	public int menu(String[] menu) {
		
		int val =  JOptionPane.showOptionDialog(null, "메뉴를 선택하세요.", "Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, menu, "6");
		if(++val == 6) {
			int op = this.check_Ok_Cancel("종료하시겠습니까?", "Exit");
			val = (op == 0) ? 0 : 10;
		}

		return val;	 // if dialog close, return 0
	
	}
	
	/**
	 * getTitle()
	 * 
	 * @param title		// now function
	 * @return
	 */
	public String getTitle(String menu) {
		
		String bookTitle = JOptionPane.showInputDialog(null, "책의 제목을 입력하세요.", menu, JOptionPane.QUESTION_MESSAGE);
		System.out.println(bookTitle);
		if (bookTitle != null) {
			return bookTitle;
		} else	{
			System.out.print(menu);
			System.out.println("] 입력이 취소되었습니다.");
			return null;
		}
		
	}
	
	/**
	 * getPrice()
	 * 
	 * input price of Book from Dialog
	 * loop until price is number or null
	 * if null, return -1
	 * 
	 * @param title		// now function
	 * @return	Integer
	 */
	public int getPrice(String menu) {
		
		String money = "";
		int price = 0;
		String msg = "책의 가격을 입력하세요.";
		boolean opt = false;
		
		while(true) {
			money = JOptionPane.showInputDialog(null, msg, menu, JOptionPane.QUESTION_MESSAGE);
			if (money != null) {
				try {
					price = Integer.parseInt(money.trim());
					if(price >=0) return price;
				} catch (NumberFormatException e) {
					System.out.println(money);
					if(opt==false) {
						msg = "잘못 입력하셨습니다. " + msg;
						opt = !opt;
					}
				}
			} else {
				System.out.print(menu);
				System.out.println("] 입력이 취소되었습니다.");
				return -1;
			}
		}
		
	}
	
	public String selectTitle(String[] titles, String menu) {
		
		String title = (String)JOptionPane.showInputDialog(null, "책 제목을 선택해주세요.", menu, 
				JOptionPane.QUESTION_MESSAGE, null, titles, null);
		
		if (title != null)
			return title;
		else {
			System.out.print(menu);
			System.out.println("] 선택이 취소되었습니다.");
			return null;
		}
				
	}
	
	public int check_Ok_Cancel(String msg, String title) {
		return JOptionPane.showConfirmDialog(null, msg, title, 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
		
	}
	
}
