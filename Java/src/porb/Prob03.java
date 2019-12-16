package porb;

import java.util.Arrays;

public class Prob03 {

	public static void main(String[] args) {
		/*
		 * Week 01 day 04 (19. 12. 05)
		 */
		
		String[] strData  = { "Java Programming" , "JDBC", "Oracle10g", "JSP/Servlet" };
		
		// toDo
		String[] endData = new String[strData.length];
		
		for (int i = 0; i < strData.length; i++) {
			endData[i] = "";
			for (int j = strData[i].length()-1 ; j >= 0; j--) {
				endData[i] += strData[i].charAt(j);
			}
		}
		
		// print result
		System.out.print("before : ");
		System.out.println(Arrays.toString(strData));
		System.out.print("after  : ");
		System.out.println(Arrays.toString(endData));
		
		
		// === 연  습  문  제  ====================
		System.out.println("======================");
		/*
		 * 예제 )문자열 참조변수  msg 가 "yes" 일때 true 인  조건식 
		*/ 
		System.out.println("Sub 01.");
		String[] yesData  = { "YES" , "Yes", "yes", "yee" };
		for (int i = 0; i < yesData.length; i++) {
			if (yesData[i].equalsIgnoreCase("Yes")) {
				System.out.print(true);
			} else
				System.out.print(false);
			System.out.print(" ");
		}
		System.out.println();
		
		  
		/*
		 * 예제) 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때 
		      몇까지 더해야 총합이  100  이상이 되는지 구하시오 .
		*/ 
		System.out.println("\nSub 02.");
		int sum2 = 0;
		int num = 1;
		while (sum2 < 100) {
			if (num%2 == 0) {
				sum2 += -num;
			} else {
				sum2 += num;
			}
			num++;	
//			System.out.print("num : ");
//			System.out.println(num);
//			System.out.print("sum : ");
//			System.out.println(sum);
		}
//		System.out.println();
		System.out.print("num : ");
		System.out.println(num);
		System.out.print("sum : ");
		System.out.println(sum2);

		/*
		 * 예제)arr 배열 에 담긴 모든 값을 더하는 프로그램을 완성하시오 .
		 * 
		 * class Exercise2 { public static void main(String[] args) { int[] arr = {10,
		 * 20, 30, 40, 50};
		 * 
		 * // TODO arr 배열 에 담긴 모든 값을 더하는 프로그램을 완성
		 * 
		 * System.out.println("sum="+sum); } }
		 */
		System.out.println("\nSub 03.");
		int[] arr = {10, 20, 30, 40, 50};
		
		// TODO arr 배열 에 담긴 모든 값을 더하는 프로그램을 완성
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println("sum="+sum);
		
		
		// + Missin
		// 중복 불허!!
		// Lotto!!!
		// 
		//  		>> day05.Test01		에서 구현
//	
//		int test = 0;
//		
//		while (test <10) {
//			test++;
//			System.out.println(test + " : before for");
//			for (int i = 0; i < 2; i++) {
//				
//				System.out.println("\t" + test + " : before if");
//				if ( test%2 == 0 ) {
//					System.out.println("\t\t" + test + " : if");
//					break;
////					continue;
//				}
//				System.out.println("\t" + test + " : afore if");
//			// continue		<<--
//			}
//			// break	<<--
//			System.out.println(test + " : afore for");
//			
//		}
//		
//		System.out.println();
//		int[] lotto = new int[6];
//		int loc = 0;
//		
//		while ( loc < 6 ) {
//			
//			int i = 0;
//			int number = (int) ((Math.random()*45) +1);
//			
//			for (i = 0; i < loc+1; i++) {
//
//				if(lotto[i] == number) {
//					break;
//				}
//				else {
//					
//				}
//			}
//			lotto[i] = number;
//			
//		}
//		Arrays.sort(lotto);
//		System.out.println(Arrays.toString(lotto));
		
	}

}
