package day10;

//import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test05 {

	public static void main(String[] args) {
		/*
		 * 
		*/
//		Set<String> set = new HashSet<String>();
		Set<String> set = new TreeSet<String>();
		set.add("lee");
		set.add("kim");
		set.add("park");
		set.add("ko");
		set.add("lee");
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String data = (String) it.next();
			System.out.println(data);
		}
		
		//
	}

}
