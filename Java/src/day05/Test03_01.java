package day05;

import java.util.Arrays;

public class Test03_01 {

	public static void main(String[] args) {
		/*
		 * 	arr.clone()
		 * 
		 * 	str.substring(int)			int~
		 * 	str.substring(int, int)		int~int
		 * 
		 * 	str.indexOf('?')
		 * 	str.lastIndexOf('/')
		 * 
		*/
		
		int[] num = { 9, 8, 1, 2, 3 };
		
//		int[] num2;
//		num2 = { 1, 2, 3 };		// error
		
//		int[] num3 = new int[] { 1, 2, 3 };
		
		int[] num2 = num;
		int[] num3 = num.clone();
		
		num2[2] = 99;
		Arrays.sort(num3);
		
		System.out.println(Arrays.toString(num));		
		System.out.println(Arrays.toString(num2));		// num과 num2가 Heap의 같은 int[]를 참조한다.
		System.out.println(Arrays.toString(num3));		// num.clone()은 num과 다른 int[]를 참조
		
		
		System.out.println("======================");
		String url = "http://myweb/admin/logic.do";
		String str = url.substring(0, 3);
		
		System.out.println(url.substring(7, 7+5));
		System.out.println(url.substring(13, 13+5));
		System.out.println(url.substring(19, url.length()));
		System.out.println(url.substring(18));
		System.out.println(str);
		System.out.println(url.substring(0, url.length()));
		System.out.println(url.substring(0, url.length()-1));
		
		System.out.println(url.substring(url.indexOf(':') ));
		System.out.println(url.substring(url.lastIndexOf('/') ));
		
//		myweb
//		admin
//		logic.do
//		/logic.do
//		htt
//		http://myweb/admin/logic.do
//		http://myweb/admin/logic.d
//		://myweb/admin/logic.do
//		/logic.do
		
		//
	}

}
