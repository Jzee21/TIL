package day06;
/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/
import java.util.Arrays;

import day05.Calc;
import Util.MyUtil;

public class Test01 {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
//		day05.Calc cal = new day05.Calc();
		// before 'import'
		
		// after 'import'
//		Calc cal = new Calc();
		
		// 'Calc.add : static method
		System.out.println(Calc.add(5, 4));
		System.out.println(day05.Calc.add(5, 4));
		
		System.out.println(Calc.add(5, 4, 5));
//		System.out.println(Calc.add(5, 4, 5, 6, 7));
		
		int[] d = { 1, 21, 3, 44, 5, 65, 7, 18, 9, 10 };
		int[] r = MyUtil.sort(d);
		
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(r));
		
		System.out.println(MyUtil.max(55, 22));
		
		
		
		//
	}

}
