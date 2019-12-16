package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 	다중 배열
		 * 		- int[][] arr;
		 * 		- char[] / String
		 * 
		*/
		
		int[][] t1 = new int[4][3];
		System.out.println("t1[0]");
		System.out.println(t1[0][0]);
		System.out.println(t1[0][1]);
		System.out.println(t1[0][2]);
		System.out.println("t1[1]");
		System.out.println(t1[1][0]);
		System.out.println(t1[0][1]);
		System.out.println(t1[0][2]);
		// .....
		
		// t2 Print 1
		System.out.println("===");
		for (int i = 0; i < t1.length; i++) {
			for (int j = 0; j < t1[i].length; j++) {
				System.out.print(t1[i][j] + " ");
			}
			System.out.println();
		}
		
		// t1 Print 2
		System.out.println();
		for (int i = 0; i < t1.length; i++) {
			System.out.println(Arrays.toString(t1[i]));
		}
		
		// t2
		System.out.println();
		int[][] t2 = { {1,2,3}, {4,5,6,7,8,9}, {0,1} };
		
		for (int i = 0; i < t2.length; i++) {
			System.out.println(Arrays.toString(t2[i]));
		}
		
		// char, String
		System.out.println("======================");
		
		char[] c = new char[5];
		
		c[0] = 'a';
		c[1] = 'b';
		
		for (int i = 0; i < c.length; i++) {
			c[i] = (char)(Math.random()*26+65);
		}
		System.out.println(Arrays.toString(c));
		
		String str = "abcdefghijklmnopqrstuvwxyz";
		char[] c2 = str.toCharArray();
		
		System.out.println(str);
		System.out.println(Arrays.toString(c2));
		
		
		//
		
	}

}
