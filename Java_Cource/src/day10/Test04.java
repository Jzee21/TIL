package day10;

//import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

/*
 * Week 02
 * 	day 10	(19. 12. 13)
 * 
*/

public class Test04 {

	public static void main(String[] args) {
		/*
		 * 	Collection
		 * 		- ArrayList
		 * 		- Iterator
		*/
//							new ArrayList<E>();		
		List<String> list = new Vector<String>();
		// check : import java.util.List;
		
		System.out.println(list.size());
		
		list.add("홍길동");
		list.add("고길동");
		list.add("나길동");
		list.add("두길동");
		
		System.out.println(list.size());
		System.out.println(list);
		
		// ===================================
		// for문 		set : index가 없어 사용 불가
		for (int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println(list.contains("고길동"));
		
		// === Iterator 기반 순회 =======================
		// while문	set도 가능
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String data = it.next();
			System.out.println(data.charAt(0));
			System.out.println(data);
		}
		
		// === Iterator 기반 삭제 =======================
		String rname = JOptionPane.showInputDialog("Delete Name.");
		it = list.iterator();
		while (it.hasNext()) {
			String data = (String) it.next();
			if(rname.equals(data)) {
				it.remove();
			}
		}
		
		System.out.println(list);
		//
	}


}
