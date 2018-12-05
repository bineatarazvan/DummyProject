package curs.ecenta.databaseConnection;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	    private static DatabaseConnection instance;
	    private Connection connection;
	    private String url = "jdbc:mysql://localhost/curs";
	    private String username = "root";
	    private String password = "12345678";

	    public DatabaseConnection() throws SQLException {
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	            this.connection = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
	    }

	    public Connection getConnection() {
	        return connection;
	    }

	    public static DatabaseConnection getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new DatabaseConnection();
	        } else if (instance.getConnection().isClosed()) {
	            instance = new DatabaseConnection();
	        }

	        return instance;
	    }
//	    private Connection conn = null;
//
//		public Connection handleConnection() {
//			String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//			String DB_URL = "jdbc:mysql://localhost/curs";// schema noastra
//
//			// Datebase credentials
//			String USER = "root";
//			String PASS = "12345678";
//
//			if (conn != null) {
//				return conn;
//			} else {
//				try {
//					// Step 2 Register JDBC driver
//					Class.forName("com.mysql.jdbc.Driver");
//
//					// STEP3 Open connection
//					System.out.println("connecting to database ...");
//					conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//				} catch (SQLException se) {
//
//					// Handle errors for JDBC
//					se.printStackTrace();
//				} catch (Exception e) {
//					// Handle errors for Class.forName
//					e.printStackTrace();
//				}
//				return conn;
//			}
//		}
//	    
	}