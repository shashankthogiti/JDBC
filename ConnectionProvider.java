package JDBC8;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "$Hashank88");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}
