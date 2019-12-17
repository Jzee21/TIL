package day06;
/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/

public class Test02 {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
//		int t1;		// hour
//		int m1;		// min
//		int s1;		// sec
		
		Time t1 = new Time();
//		t1.hour = 13;
//		t1.minute = 30;
		t1.setHour(13);
		t1.setHour(-13);
		t1.setminute(30);
		t1.print();
		
		Time t2 = new Time(15, 20);
		t2.print();
		
		
		//
	}

}

class Time {
	private int hour;
	private int minute;
	private int second;
	
	// 생성자		나혼자 끄적끄적
	Time () {
		
	}
	
	Time ( int hour, int minute ) {
		this.hour = hour;
		this.minute = minute;
	}
	
	Time ( int hour, int minute, int second ) {
		this(hour, minute);
		this.second = second;
	}
	
	public int getHour () {
		return this.hour;
	}
	
	public void setHour( int hour) {
		if(hour >= 0 && hour < 24)
			this.hour = hour;
	}
	
	public int getMinute () {
		return this.minute;
	}
	
	public void setminute( int minute) {
		if(minute >= 0 && minute < 60)
			this.minute = minute;
	}
	
	public int getSecond () {
		return this.second;
	}
	
	public void setSecond( int second) {
		if(second >= 0 && second < 60)
			this.second = second;
	}
	
	public void print() {
		System.out.printf("( %2dh : %2dm : %2ds )\n", this.hour, this.minute, this.second);
	}
}