package day04;

public class Test04 {

	public static void main(String[] args) {
		/*
		 *	배열	Array!
		 *	  [같은 타입의 여러 변수]를 하나의 묶음으로 다루는 것. 
		*/
		
		// int Array
		int[] eng;				// 배열 선언	- Stack area
		eng = new int[5];		// 배열 생성	- Heap area (feat. new)
		
		// 수동
		eng[0] = 99;
		eng[1] = 88;
		eng[2] = 100;
		eng[3] = 81;
		eng[4] = 76;
		
		double sum = 0;
		double avg = 0.0;
		
		for ( int i=0 ; i<eng.length ; i++ ) {
			System.out.printf("| %3d ", eng[i]);
			sum += eng[i];
		}
		System.out.println("|");
		
		avg = sum / eng.length;
		
		System.out.printf("sum = %8.2f\n", sum);
		System.out.printf("avg = %8.2f\n", avg);
		
		System.out.println();
		System.out.println("======================");
		
		// String Array
		String[] names = new String[5];
		
		names[0] = "홍길동";
//		names[1] = "가길동";
		names[1] = null;		// be Error
//		names[1] = "";			// be Error
		names[2] = "나길동";
		names[3] = "다길동";
		names[4] = "라길동";
		
		for (int i = 0; i < names.length; i++) {
			if ( names[i] != null  && names[i].length() > 0 ) {		// null이 아닐 때 뒤에 . 참조 사용 가능
//			if ( names[i].length() > 0 && names[i] != null ) {		// so, Error
				System.out.print(names[i].charAt(0));
				System.out.print("** : ");
				System.out.printf("%3d\n", eng[i]);
			}						
		}
		System.out.println("\n");
		
		//
	}

}

