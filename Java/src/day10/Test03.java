package day10;
/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

import java.util.Stack;

public class Test03 {

	public static void main(String[] args) {
		/*
		 *	java.util.Stack 
		*/
		Stack<String> st1 = new Stack<String>();
		Stack<Integer> st2 = new Stack<Integer>();
		
		System.out.println(st1.push("~~~~"));	//	~~~~
		System.out.println(st1.pop());			//  ~~~~
		System.out.println(st1.empty());		// 	true
		
		System.out.println(st2.push(99));		// 	99
		System.out.println(st2.peek());			//	99
		System.out.println(st2.empty());		// 	false
		
		//
	}

}
