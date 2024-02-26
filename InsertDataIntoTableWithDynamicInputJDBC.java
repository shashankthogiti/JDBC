import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertDataIntoTableWithDynamicInputJDBC {
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
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name:");
			String name = br.readLine();
			
			System.out.println("Enter city:");
			String city = br.readLine();

			// set the values to query
			pstmt.setString(1, name);
			pstmt.setString(2, city);

			pstmt.executeUpdate();
			System.out.println("inserted..........");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
