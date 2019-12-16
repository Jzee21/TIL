package day01;

public class Sample03 {

	public static void main(String[] args) {
//		System.out.print("홍길동");
//		System.out.print('A');
//		System.out.print(true);
//		System.out.print(3.14);
//		System.out.print(300);
		System.out.println("홍길동" + "\t" + 'A' + "\t" + true + "\t" + 3.14 + "\t" + 300);
		// ㄴ 성능 저하를 유발하는 코드 (+연산)
		System.out.printf("%s %c %b %.2f %d a%n","홍길동", 'a', true, 3.14, 300);
		System.out.printf("%s %c %b %f %d %n","홍길동", 'a', true, 3.14, 300);
		
		float f = (float) 5.5;
		float f2 = 5.5f;
		float f3 = .5f;
		double d = 5;
		
		System.out.println(f);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(d);
		
		int i = (int) .1f;
		System.out.println(i);
		
		String s = "aaaaaa";
		System.out.println(s);

	}

}
