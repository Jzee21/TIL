package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

import javax.swing.JOptionPane;

public class Test01 {

	public static void main(String[] args) {
		/*
		 *	Command Design Pattern
		*/
		Command cmd = null;
		
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
				cmd = new DeleteCommand();
				break;
			case "2" :
			case "insert" :
				cmd = new InsertCommand();
				break;
			case "3" :
			case "update" :
				cmd = new UpdateCommand();
				break;
			default:
//				System.out.println("I can process this Command");
				cmd = new ListCommand();
				break;
		}
		
		if (cmd != null) {
			cmd.exec();
			cmd.base();
		}
		
	}

}

interface Command {
	void exec();
	default public void base() {
		System.out.println("Command_base()");
	}
}

class DeleteCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("execute Delete...");
	}
	
}

class InsertCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("execute Insert...");
	}
	
}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("execute Update...");
	}
	
	@Override
	public void base() {
		System.out.println("UpdateCommand_base()");
	}
	
}

class ListCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("execute List?!");
	}
	
}
