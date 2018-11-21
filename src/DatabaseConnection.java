import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn = null;

	public Connection handleConnection() {
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/curs";// schema noastra

		// Datebase credentials
		String USER = "root";
		String PASS = "12345678";

		if (conn != null) {
			return conn;
		} else {
			try {
				// Step 2 Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP3 Open connection
				System.out.println("connecting to database ...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

			} catch (SQLException se) {

				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			return conn;
		}
	}
}