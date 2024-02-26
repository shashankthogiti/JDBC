package JDBC5;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;

import JDCB5.ConnectionProvider;

public class InsertingLargeImageToDatabase {

	public static void main(String[] args) {
		try {

			// System.out.println("this is testing");

			Connection c = ConnectionProvider.getConnection();
			
			String q = "insert into images(pic) values(?)";

			PreparedStatement pstmt = c.prepareStatement(q);
			
			JFileChooser jfc = new JFileChooser();

			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();

			FileInputStream fis = new FileInputStream(file);

			pstmt.setBinaryStream(1, fis, fis.available());

			pstmt.executeUpdate();

			System.out.println("Done...");

			// JOptionPane.showMessageDialog(null, "success");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
