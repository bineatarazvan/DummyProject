package curs.ecenta.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import curs.ecenta.beans.UserBean;
import curs.ecenta.databaseConnection.DatabaseConnection;

public class UserDAO {
	public ArrayList<UserBean> GetUsers() {
		ArrayList<UserBean> users = new ArrayList<>();
		
		Connection con = null;
		Statement stmt = null;
		try {
			DatabaseConnection dbcon = DatabaseConnection.getInstance();
			con=dbcon.getConnection();
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setIduser(rs.getInt("iduser"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
//	public void insertUsers() throws SQLException {
//		ArrayList<UserBean> users = new ArrayList<>();
//		DatabaseConnection dbcon = new DatabaseConnection();
//		Connection con = dbcon.getConnection();
//		Statement stmt = null;
//		try {
//			stmt = con.createStatement();
//			String sql;
//			 sql = "INSERT INTO user " +"VALUES (4, 'Zaza', 'All', 'za','12')";
//	      stmt.executeUpdate(sql);
//			 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//		      //finally block used to close resources
//		      try{
//		         if(stmt!=null)
//		            con.close();
//		      }catch(SQLException se){
//		      }// do nothing
//		      try{
//		         if(con!=null)
//		            con.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }//end finally try
//		   }//end try
	
//	public void insertUsers() throws SQLException {
//		ArrayList<UserBean> users = new ArrayList<>();
//		DatabaseConnection dbcon = new DatabaseConnection();
//		Connection con = dbcon.handleConnection();
//		Statement stmt = null;
//		try {
//			stmt = con.createStatement();
//			String sql;
//			 sql = "INSERT INTO user " +
//	                   "VALUES (4, 'Zara', 'Ali', '18','as')";
//	      stmt.executeUpdate(sql);
//			 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//		      //finally block used to close resources
//		      try{
//		         if(stmt!=null)
//		            con.close();
//		      }catch(SQLException se){
//		      }// do nothing
//		      try{
//		         if(con!=null)
//		            con.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }//end finally try
//		   }//end try
//	}
////	}
}
