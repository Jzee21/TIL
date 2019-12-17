package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test07 {

	public static void main(String[] args) {
		/*
		 * 	Map
		*/
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("java01", "1231");	// 01
		map.put("java02", "1232");
		map.put("java03", "1233");
		map.put("java04", "1234");
		map.put("java05", "1235");
		map.put("java06", "1236");
		map.put("java07", "1237");
		map.put("java08", "1238");
		map.put("java01", "1239");	// 01. overwrite
		
		System.out.println(map);
		System.out.println(map.size());
		
		// Map Check
//		System.out.println(map.keySet());
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String id = (String) it.next();
			System.out.print(id);
			System.out.print(" : ");
			System.out.print(map.get(id));
			System.out.println();
		}
		
		// Login
//		Set<String> keys = map.keySet();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter ID\n>> ");
			String idmsg = sc.nextLine().trim();
			System.out.println("Enter PW\n>> ");
			String pwmsg = sc.nextLine().trim();
			
			if(map.containsKey(idmsg)) {
				if(map.get(idmsg).equals(pwmsg)) {
					System.out.println("Login Success");
					break;
				}
				else
					System.out.println("Login Fail. Check your PW");
			} else {
				System.out.println("Login Fail. Check your ID");
			}
			
		}
		
		//
		
		sc.close();
		sc = null;
	}

}
