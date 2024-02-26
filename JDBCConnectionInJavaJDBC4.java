//insert record in database through Preparaed Statement part 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCConnectionInJavaJDBC4 {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/learncoding";
			String username = "root";
			String password = "$Hashank88";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstmt = con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Enter Emp id:");
				int eno = Integer.parseInt(br.readLine());

				System.out.println("Enter Emp Name:");
				String ename = br.readLine();

				System.out.println("Enter Emp Salary:");
				double sal = Double.parseDouble(br.readLine());
				
				pstmt.setInt(1, eno);
				pstmt.setString(2, ename);
				pstmt.setDouble(3, sal);
				
				int count = pstmt.executeUpdate();
				
				if(count>0) {
					System.out.println(count + "record inserted");
				} else {
					System.out.println("No record inserted");
				}
				
				System.out.println("Do you want to insert more records?....yes/no");

				String ch = br.readLine();
				if (ch.equalsIgnoreCase("YES")) {
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
