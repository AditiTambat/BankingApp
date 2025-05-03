import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			// Step 1 Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2 Create Connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useSSL=false" , "root", "root");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
