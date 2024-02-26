import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertDataIntoTableUsingPreparedStatementJDBC2 {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/youtube";
			String username = "root";
			String password = "$Hashank88";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			// create a query
			String q = "insert into table1(tName,tCity) values(?,?)";
			
			// get the PreparedStatement object
			PreparedStatement pstmt = con.prepareStatement(q);

			// set the values to query
			pstmt.setString(1, "Harshavardhan");// changing the values from FirstJDBC
			pstmt.setString(2, "INDIA");// changing the values from FirstJDBC //After changing values we are going to
										// get dual values

			pstmt.executeUpdate();
			System.out.println("inserted.....");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
