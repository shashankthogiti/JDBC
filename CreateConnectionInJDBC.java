import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionInJDBC {
	public static void main(String[] args) {
		try {

			// 1.Load the Drive
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/youtube";
			String username = "root";
			String password = "$Hashank88";
			
			// 2.Creating a Connection
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
