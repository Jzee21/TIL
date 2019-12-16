package day09;
/*
 * Week 02
 * 	day 09	(19. 12. 12)
 * 
*/

public class Test09 {

	public static void main(String[] args) {
		/*
		 * 	User Defined Exception Handling.
		 * 	- MoneyException
		 * 
		*/
		Account account = new Account("홍길동", "001", 1000);
		System.out.println("Start");
		
		try {
			System.out.println("try");
			account.output(7000);
			System.out.println("pass try");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//
		System.out.println("End");
	}

}

// user defined exception
class MoneyException extends Exception{
	
	MoneyException() {
		super("잔고 부족");
	}
	
	MoneyException(String msg) {
		super(msg);
	}
	
}

class Account {
	//
	String name;
	String number;
	int balance;
	
	public Account() {
		
	}
	
	public Account(String name, String number, int balance) {
		super();
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	// method
	public void input(int money) {
		this.balance += money;
	}
	
	public int output(int money) throws MoneyException{		// Method 호출 시 try-catch로 처리하기를 요청
		if (this.balance < money) {							// ex) 에러 내용을 클라이언트에게 전달할 때 등
			throw new MoneyException();						// Exception -> MoneyException (user defined)
		}
		this.balance -= money;
		return money;
	}
	
	// getter, setter
	
	
	// hashCode, equals, toString
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

	@Override
	public String toString() {
		return "Account [name=" + name + ", number=" + number + ", balance=" + balance + "]";
	}
	
}