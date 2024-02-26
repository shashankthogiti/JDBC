import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableInJDBC2 {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/learncoding";
			String username = "root";
			String password = "$Hashank88";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			String q = "create table emp(eno int(20) primary key auto-incerment,ename varchar(12) not null,esal int(20))";// eno=employ
																												// number
			
			Statement stmt = con.createStatement();

			stmt.executeUpdate(q);

			System.out.println("Table created successfully");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
