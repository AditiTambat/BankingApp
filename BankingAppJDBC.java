import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BankingAppJDBC {
	static Scanner sc;

	public static void main(String[] args) {
		createTable();
		int opt = 0;
		do {
			System.out.println();
			System.out.println("1. Add new bank account ");
			System.out.println("2. Show all bank accounts ");
			System.out.println("3. Delete Bank account ");
			System.out.println("4. Update Bank account ");
			System.out.println("5. Deposit amount ");
			System.out.println("6. Withdraw amount ");
			System.out.println("7. Show balance ");
			System.out.println("8. Show total amount ");
			System.out.println("10. Exit");
			System.out.println("Enter your option ");
			sc = new Scanner(System.in);
			opt = sc.nextInt();
			switch (opt) {
			case 1: addAccount();
				break;
			case 2: showAllAccounts();
				break;
			case 3 : deleteAccount();
				break;
			case 4 : updateAccount();
				break;
			case 5 : deposit();
				break;
			case 6 : withdraw();
				break;
			case 8 : showTotalAmount();
				break;
			}
		} while (opt != 10);
	}
	
	

	private static void showTotalAmount() {
		
	}

	private static void updateAccount() {
		
	}

	private static void deleteAccount() {
		int a = sc.nextInt();
		try {
			Connection con = MyConnection.getConnection();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	private static void withdraw() {
		System.out.println("Enter the account number to withdraw");
		int a = sc.nextInt();
		try {
			Connection con = MyConnection.getConnection();
			String qry = "select * from bankaccount where acno=?";
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, a);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Enter the amount to withdraw ");
				float x = sc.nextFloat();
				float b = rs.getFloat(4);
				if (b > x) {
					b = b - x;
					String q = "update bankaccount set balance=? where acno=?";
					PreparedStatement pstmt2 = con.prepareStatement(q);
					pstmt2.setFloat(1, b);
					pstmt2.setInt(2, a);
					pstmt2.executeUpdate();
					System.out.println("Your withdraw transaction is successfull.");
					System.out.println("Your new balance amount : " + b);

				} else {
					System.out.println("Invalid withdraw amount");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	private static void deposit() {
		System.out.println("Enter the account number to deposit");
		int a = sc.nextInt();
		try {
			Connection con = MyConnection.getConnection();
			String qry = "select * from bankaccount where acno=?";
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, a);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Enter the amount to deposit ");
				float x = sc.nextFloat();
				float b = rs.getFloat(4);
				b = b + x;
				String q = "update bankaccount set balance=? where acno=?";
				PreparedStatement pstmt2 = con.prepareStatement(q);
				pstmt2.setFloat(1, b);
				pstmt2.setInt(2, a);
				pstmt2.executeUpdate();
				System.out.println("Your Deposit transaction is successfull.");
				System.out.println("Your new balance amount : " + b);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void showAllAccounts() {
		try {
			Connection con = MyConnection.getConnection();
			String qry = "select * from bankaccount";
			PreparedStatement pstmt = con.prepareStatement(qry);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<BankAccount> accountlist = new ArrayList<>();
			while (rs.next()) {
				int a = rs.getInt(1);
				String n = rs.getString(2);
				String d = rs.getString(3);
				float b = rs.getFloat(4);
				String p = rs.getString(5);
				BankAccount b1 = new BankAccount(a, n, d, b, p, p);
				accountlist.add(b1);
			}
			System.out.println("=======================================================================");
			System.out.println("Account no.       Name              Address      Balance      Phone ");
			System.out.println("=======================================================================");
			for (BankAccount b : accountlist) {
				System.out.printf("%4d%20s%17s%15.2f%15s", b.getAccno(), b.getName(), b.getAddress(), b.getBalance(), b.getBranch(),b.getPhone());
			}
		} catch (Exception e) {

		}
	}

	private static void addAccount() {
		try {
			sc.nextLine();
			System.out.println("Enter Name");
			String n = sc.nextLine();
			System.out.println("Enter the address");
			String a = sc.nextLine();
			System.out.println("Enter the balance ");
			float b = sc.nextFloat();
			System.out.println("Enter the phone");
			String p = sc.next();
			Connection con = MyConnection.getConnection();
			String qry = "insert into bankaccount(acname,address,balance,phone) values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(qry);

			pstmt.setString(1, n);
			pstmt.setString(2, a);
			pstmt.setFloat(3, b);
			pstmt.setString(4, p);

			pstmt.executeUpdate();
			System.out.println("Your New Bank Account is created.");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void createTable() {
		try {
			Connection con = MyConnection.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"create table if not exists bankaccount(acno int primary key auto_increment,acname varchar(30),address varchar(30),balance float,phone varchar(10))");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
