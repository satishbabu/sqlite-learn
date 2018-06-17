package learn.sqlite_learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlite:/projects/sqlite/test.db")) {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select name from employee");

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
	}
}
