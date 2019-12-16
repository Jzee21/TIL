package Util;

import java.util.Iterator;
import java.util.List;

public class MyUtil {
	
	public static int[] sort( int[] a ) {
		
		int[] arr = a.clone();
		// protect original array, a
		
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {	// j=i+1 : compare i & i+1~
				if ( arr[min] > arr[j] ) {				// 		   except i & i
					min = j;
				}
			}
			if ( i != min ) {
				swap(arr, i, min);				// swap 에서 static이 사라지면 Error
//				MyUtil.swap(arr, i, min);
			}
		}
		
		return arr;
	}
	
	public static void swap ( int[] arr, int i, int j ) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static int max(int a, int b) {
//		Math.max(a, b);		
		return a>=b ? a : b ;
		
	}
	
	public static void iteratorPrint(List<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String data = (String) it.next();
			System.out.print(data);
			System.out.print(" ");
		}
		System.out.println();
	}

}
