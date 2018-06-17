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
public class App 
{
	public static Connection connect() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/projects/sqlite/test.db");
			return conn;
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
    public static void main( String[] args ) throws SQLException
    {
    	Connection conn = connect();
    	
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("Select name from employee");
    	
    	while (rs.next()) {
    		System.out.println(rs.getString(1));
		}
    }
}
