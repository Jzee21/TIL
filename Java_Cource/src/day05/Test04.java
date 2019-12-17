package day05;

public class Test04 {

	public static void main(String[] args) {
		/*
		 * 	for 문
		 * 		new Option!
		 * 
		 * 		for ( int data :array )
		 * 
		*/
		
		int[] num = { 1, 2, 3 };
		for (int data :num) {
			if(data %2 != 0) {
				System.out.print(data);		// System.out.print(data + ' ')
				System.out.print(' ');		// ㄴ print int
			}
		}
		System.out.println();
		
		char[] c = "ABCD".toCharArray();
		for (char data :c) {
			System.out.print((char)data);
			System.out.print(' ');
		}
		System.out.println();
		
		String[] s = { "Hello", "java", "test" };
		for (String data :s) {
			if(data.charAt(0) == 'j') {
				System.out.println(data);
			}
		}
		
		
		//
	}

}
