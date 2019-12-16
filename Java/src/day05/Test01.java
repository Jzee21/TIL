package day05;

import java.util.Arrays;

/*
 * Week 01
 * 	day 05	(19. 12. 06)
 * 
*/
public class Test01 {

	public static void main(String[] args) {
		/*
		 * 	duplication check
		 * 		for Lotto!!
		 * 
		 * 	Sort
		 * 
		*/
		
		// add after Test03.
		int size = 5;
		if ( args.length != 0 ) {
			size = Integer.parseInt(args[0]);
		}
		
		// add after Test03.
		
		// change 6 to size
		// ! size : 46~ 	Error. why?
//		int[] num = new int[6];
		int[] num = new int[size];
		
		
		// duplication check
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*45+1);
			for (int j = 0; j < i; j++) {
				if ( num[j] == num[i] ) {
					i--;				// break - for로 이동하여 i값 유지			// if --, break, for ++
					break;				// 현재 i값 위치에 random num 새로 적용		// -1 +1 = 0	re : num[0] = Math.random()
				}
			}
		}
		System.out.println("===");
		System.out.println(Arrays.toString(num));
		
		// Sort
		for (int i = 0; i < num.length-1; i++) {
			int min = i;
			for (int j = i+1; j < num.length; j++) {	// j=i+1 : compare i & i+1~
				if ( num[min] > num[j] ) {				// 		   except i & i
					min = j;
				}
			}
			// Swap with minNum
			if ( i != min ) {
				int temp = num[i];
				num[i] = num[min];
				num[min] = temp;
			}
		}
		
		System.out.println("===");
//		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		
	}

}
