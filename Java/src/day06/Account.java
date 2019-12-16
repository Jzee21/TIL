package day06;

public class Account {
	private String name;
	private String number;
	private int balance;
	
	public Account () {
		this("", "", 0);
	}
	
	public Account (String number, String name) {
		this(number, name, 0);
	}

	public Account (String number, String name, int money) {
		this.setNumber(number);
		this.setName(name);
		this.setBalance(money);
	}
	
	// Auto setter, getter
	// F10 - source - Generate Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	// -------------------------------------------

	/**
	 * 
	 * @param money : 입금금액
	 */
	public void input ( int money ) {
		this.balance += money;
		this.print();
	}
	
	/**
	 * 
	 * @param money : 출금금액
	 * @return		: 출금액
	 */
	public int output ( int money ) {
		if (this.balance >= money) {
			this.balance -= money;
			this.print();
			return money;
		}
		else {
			System.out.println("Balance is not enough.");
			return 0;
		}
	}
	
	/**
	 * 
	 */
	public void print () {
		System.out.printf("[ %s(%s) 잔액 : %,9d 원 ]\n", 
				this.number, this.name, this.balance);
	}
	
	/**
	 * 
	 * @param from  출금계좌
	 * @param to    입금계좌
	 * @param money 송금액
	 */
	public static void transfer (Account from, Account to, int money) {
		System.out.println("[계좌이체]");
		System.out.printf("%s -> %s : %,d\n", from.number, to.number, money);
		to.input(from.output(money));
	}

	/**
	 * 
	 * @param to    입금계좌
	 * @param money 송금액
	 */
	public void transfer (Account to, int money) {
		to.input(this.output(money));
	}
	
}
