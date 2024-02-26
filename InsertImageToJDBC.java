import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertImageToJDBC {
	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/youtube";
			String username = "root";
			String password = "$Hashank88";
			
			Connection con = DriverManager.getConnection(url, username, password);
			
			String q = "insert into images(pic) values(?)";

			PreparedStatement pstmt = con.prepareStatement(q);

			FileInputStream fis = new FileInputStream("C:\\Users\\shash\\Downloads\\signature.jpg");// insert photo
			// Above we had created the path and insertes image because the image is in the
			// another folder

			pstmt.setBinaryStream(1, fis, fis.available());

			pstmt.executeUpdate();

			System.out.println("Done...");

		} catch (Exception e) {
			System.out.println("Error !!");
		}
	}

}
