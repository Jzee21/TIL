package day08;
/*
 * Week 02
 * 	day 08	(19. 12. 11)
 * 
*/

public class Test05 {

	public static void main(String[] args) {
		/*
		 * 
		*/
		
		Account a1 = new Account("Kim", "001", 300);
		Account a2 = new Account("Lim", "002", 1300);
		Account a3 = new Account("Kim", "001", 300);
		
		System.out.println(a1);			// before override toString()		// print address
		System.out.println(a2);
												// before override equals()	// after
		System.out.println(a1.equals(a2));		// false					// false
		System.out.println(a1.equals(a3));		// false					// true
		
		//
	}

}

class Account {	// extends Object
	
	String name;
	String number;
	int balance;		// 잔고
	
	public Account() {
		super();
	}

	public Account(String name, String number, int balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (balance != other.balance)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
}