package day05;

import java.util.Arrays;

public class Test03 {

	public static void main(String[] args) {
		/*
		 * 	How to use 'args'!
		 * 		F10 - Run - Run Configurations...
		 * 		Arguments - Program Arguments...
		 */
		
		System.out.println(args);
		System.out.println(args.length);
		System.out.println(Arrays.toString(args));
		
		/*
		 * Do Not use like this.
		 * if arguments is empty, Program return Error Please
		 * check before usiing args.
		 */
//		System.out.println(args[0].charAt(0) + "**");
		
		if (args.length == 0) {
			System.out.println("Error. Please run with parameter.");
		}
		else {
			System.out.println(args[0].charAt(0) + "**");
		}
		
		
		//
		
	}

}
