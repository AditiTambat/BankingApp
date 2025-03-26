import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountApp {
	static Scanner sc ;
	static BankAccount b1 = null;
	private static String branch;
	static ArrayList<BankAccount> banklist = new ArrayList<BankAccount>();
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("1. Add a new bank account");
			System.out.println("2. Choose for deposit money");
			System.out.println("3. Choose for withdraw money");
			System.out.println("4. Choose for show balance");
			System.out.println("5. Choose for show account deatils");
			System.out.println("10. Exit.");
			System.out.println("Choose your option: ");
			opt = sc.nextInt();
			
			//for choosing multiple option
			
			switch(opt) {
				case 1 : crateaccount();
					break;
				case 2 : depositmoney();
				 	break;
				case 3 : withDrawMoney();
					break;
				case 4 : showBalance();
					break;
				case 5 : showDetails();
					break;
			}
		}while(opt != 10);
	}

	private static void showDetails() {
	    System.out.println("Enter Account No.: ");
	    int accno = sc.nextInt();
	    boolean found = false; 

	    for (BankAccount b : banklist) {
	        if (b.getAccno() == accno) {
	            b.showDetails();
	            System.out.println();
	            found = true;
	            break; 
	        }
	    }

	    // If account not found, throw exception
	    if (!found) {
	        try {
	            throw new InvalidAccountException();
	        } catch (InvalidAccountException e) {
	            System.err.println("Alert: " + e.getMessage());
	            System.out.println();
	        }
	    }
	}


	private static void showBalance() {
		System.out.println("Enter Account No.: ");
		int accno = sc.nextInt();
	    boolean found = false; 

		for(BankAccount b : banklist) {
			if(b.getAccno()== accno) {
				System.out.println("your balance is: "+ b.showBalance());
				System.out.println();
				found = true;
	            break; 
			}
		}
		 if (!found) {
		        try {
		            throw new InvalidAccountException();
		        } catch (InvalidAccountException e) {
		            System.err.println("Alert: " + e.getMessage());
		            System.out.println();
		        }
		 }
	}

	private static void withDrawMoney() {
		try {
			System.out.println("Enter Account No.: ");
			int accno = sc.nextInt();
			System.out.println("Enter the amount for withdraw money: ");
			float amount = sc.nextFloat();
			
			for(BankAccount b: banklist) {
				if(b.getAccno()==accno) {
						b.withDraw(amount);
						System.out.println("Now your balance is: "+b.showBalance());
						System.out.println();
				 } 
				 break; 
			}
		}
		catch (InvalidBalanceException e) {
            System.err.println("Alert: " + e.getMessage());  
            System.out.println();
        }
	} 		

	private static void depositmoney() {
	    System.out.print("Enter Account No.: ");
	    int accno = sc.nextInt();
	    boolean found = false;

	    for (BankAccount b : banklist) {
	        if (b.getAccno() == accno) {
	            found = true;
	            
	            System.out.println("Enter the amount for deposit money: ");
	            float amount = sc.nextFloat();

	            b.deposit(amount);
	            System.out.println("Now your balance is : " + b.showBalance());
	            System.out.println();
	            break;  
	        }
	    }
	    if (!found) {
	        try {
	            throw new InvalidAccountException();
	        } catch (InvalidAccountException e) {
	            System.err.println("Alert: " + e.getMessage());
	            System.out.println();
	        }
	    }
	}	

	private static void crateaccount() {
		String name,adds;
		System.out.println("Enter your Name: ");
		name = sc.next();
		System.out.println("Enter your address: ");
		adds = sc.next();
		System.out.println("Enter Account No.: ");
		int accno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter balance: ");
		float balance = sc.nextFloat();
		sc.nextLine();
		System.out.println("Enter branch: ");
		String branch = sc.nextLine();
		
		
		b1 = new BankAccount(accno, name, adds,balance, branch);
		banklist.add(b1);
		System.out.println("Account created successfully!!");
		System.out.println();
		
	}
}
