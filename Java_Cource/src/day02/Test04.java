package day02;

public class Test04 {

	public static void main(String[] args) {
		
		int num = 100;
		num = num + 20;
		
		//
		int i = 99, j = 77;
		System.out.printf("| i : %2d | j : %2d |\n", i, j);
		// swap i, j
		int temp = i;
		i = j;
		j = temp;
		System.out.println("---- swap i, j ----");
		System.out.printf("| i : %2d | j : %2d |\n", i, j);
		
		//
		System.out.println("======================");
		
		char c1 = 'B', c2 = 'W';
		System.out.printf("| c1: %2c | c2 : %2c |\n", c1, c2);
		char tempChar = c1;
		c1 = c2;
		c2 = tempChar;
		System.out.println("---- swap c1, c2 ----");
		System.out.printf("| c1: %2c | c2 : %2c |\n", c1, c2);

		//
		System.out.println("======================");
		String s1 = "hello", s2 = "world";
		System.out.printf("| s1: %6s | s2 : %6s |\n", s1, s2);
		String tempStr = s1;
		s1 = s2;
		s2 = tempStr;
		System.out.println("---- swap s1, s2 ----");
		System.out.printf("| s1: %6s | s2 : %6s |\n", s1, s2);
		
		
	}

}
