package JDBC8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeletingDataOfTable {

	public static void main(String[] args) {
		try {

			Connection con = ConnectionProvider.getConnection();

			String q = "delete from table1 where tId=?";

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter delete Id");
			int id = Integer.parseInt(br.readLine());

			PreparedStatement pstmt = con.prepareStatement(q);

			pstmt.setInt(1, 1);

			pstmt.executeUpdate();

			System.out.println("Done...");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
