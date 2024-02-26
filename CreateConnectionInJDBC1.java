import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionInJDBC1 {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/learncoding";
			String username = "root";
			String password = "$Hashank88";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			if (con.isClosed()) {
				System.out.println("Connection is closed");
			} else {
				System.out.println("Connection Created...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
