package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

import javax.swing.JOptionPane;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * Inner class Example.
		 * Anonymous class
		*/
		Controller cmd = new DeleteController();
		cmd.exec();

		// Test03$1.class
		Controller insert = new Controller() {
			@Override
			public void exec() {
				System.out.println("insert");
			}
		};
		
		// Test03$2.class
		//					new + ( Ctrl + Space )
		Controller update = new Controller() {
			@Override
			public void exec() {
				System.out.println("update");
			}
		};
		
		// Test03$3.class
		Controller delete = new Controller() {
			@Override
			public void exec() {
				System.out.println("delete");
			}
		};
		
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
		
	}

}

interface Controller {
	void exec();
}

class DeleteController implements Controller {
	@Override
	public void exec() {
		System.out.println("DeleteController");
	}
}