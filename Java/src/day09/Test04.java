package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

import javax.swing.JOptionPane;

public class Test04 {

	public static void main(String[] args) {
		/*
		 * Test03 copy
		 * Anonymous class -> Lambda method**************** 
		 * 	인터페이스 안에 추상메서드가 단 하나일 때 람다식 적용이 가능하다.
		 *  이너클래스로 적용되지 않고 함수로 바인딩 된다.
		*/
		Controller cmd = new DeleteController();
		cmd.exec();

		// Lambda Method***
		// class x, method o
		Controller insert = ()-> System.out.println("insert");
		Controller update = ()-> System.out.println("update");
		Controller delete = ()-> System.out.println("delete");
		
		// menu
		String msg = 
				JOptionPane.showInputDialog(
						"Enter the Command.\n"
						+ "1. delete\n"
						+ "2. insert\n"
						+ "3. update\n"
						);
		
		switch (msg) {
			case "1" :
			case "delete" :
				cmd = delete;
				break;
			case "2" :
			case "insert" :
				cmd = insert;
				break;
			case "3" :
			case "update" :
				cmd = update;
				break;
			default:
				System.out.println("I can process this Command");
				break;
		}
		
		if (cmd != null) {
			cmd.exec();
		}
		

		//
	}

}

// already defined
//interface Controller {
//	void exec();
//}

// already defined
//class DeleteController implements Controller {
//	@Override
//	public void exec() {
//		System.out.println("DeleteController");
//	}
//}