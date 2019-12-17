package day02;

import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
		String msg = "Hello World";
		System.out.println(msg);
		int strLen = msg.length();
		
		System.out.println(msg.length());
		System.out.println(strLen);
		System.out.println(msg.toUpperCase());
		
//		java.util.Date date = new java.util.Date();
//		ㄴ before import Date
		Date date = new Date();
		System.out.println(date);
//		System.out.println(date.toLocaleString());
		//	ㄴ deprecated function
		//	    구버전에서 주로 사용되었으나 대체되는 다른 함수가 있음
		
		
//		Date date2;
//		java.sql.Date date2;
//		java.sql.Date date2 = new java.sql.Date(0);
//		System.out.println(date2);
		
	}

}
