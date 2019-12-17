package day06;
/*
 * Week 02
 * 	day 06	(19. 12. 09)
 * 
*/

public class TVTest {

	public static void main(String[] args) {
		/*
		 *	TvTest 
		*/
		
		TV t1 = new TV();
		t1.size = 65;
		t1.model = "SE65AEVER";
		t1.powerOn();
		t1.setChannel(11);
		t1.channelDown();
		t1.channelDown();
		
		TV t2 = new TV();
		t2.size = 57;
		t2.model = "LG57ESDER";
		t2.powerOn();
		t2.setChannel(21);
		
//		t1.print();
//		t2.print();
		
		TV[] tvs = new TV[30];
		tvs[0] = t1;
		tvs[1] = t2;
		
		t1 = null;
		t2 = null;
		
		for (int i = 0; i < tvs.length; i++) {
			System.out.println(i);
			if (tvs[i] != null) {
				tvs[i].powerOn();
				tvs[i].print();
			}
			else
				break;
		}
		
		
		//
	}

}

class TV {
	int size;
	String model;
	int channel;
	boolean power;
	
	public void print() {
		System.out.printf("TV ( %5s (%d inch) | power : %b, Ch : %d )\n", 
				this.model, this.size, this.power, this.channel);
	}
	
	public void powerOn() {
		this.power = true;
	}
	
	public void powerOff() {
		this.power = false;
	}
	
	public void channelUp() {
		this.channel++;
	}
	
	public void channelDown() {
		this.channel--;
	}
	
	public void setChannel( int ch ) {
		this.channel = ch;
	}
	
}