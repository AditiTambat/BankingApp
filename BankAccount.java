
public class BankAccount {
	private int accno;
	private String name;
	private String address;
	private float balance;
	private String branch;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public BankAccount(int accno, String name, String address, float balance, String branch) {
		super();
		this.accno = accno;
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.branch = branch;
	}
	public BankAccount() {
		super();
	}
	
	public float showBalance() {
		return balance;
	}
	
	public void deposit(float amt) {
		balance = balance + amt;
	}
	
	public void withDraw(float amt) {
			if(amt<=balance) {
				balance = balance - amt;	
			}
			else {
				throw new InvalidBalanceException();
			}
	}
	
	public void showDetails() {
		if(accno == accno) {
			System.out.println("Account No: "+accno+"\t\t"+"Account holder name: "+name+"\t"+"Address: "+address+"\t"+"Account balance: "+balance+"\t\t"+"Branch Name: "+branch);
		}else {
			throw new InvalidAccountException();
		}

	}
	
}
