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
	
	public String getLoginUser(UserBean loginUser) {
		String firstName=null;
		
		Connection con = null;
		Statement stmt = null;
		try {
			DatabaseConnection dbcon = DatabaseConnection.getInstance();
			con=dbcon.getConnection();
			stmt = con.createStatement();
			String sql;
			sql = "SELECT firstName FROM user where username=\""+loginUser.getUsername()+"\" and password=\"" + loginUser.getPassword()+"\"";
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				firstName = rs.getString("firstName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstName;
	}
	
	public String getRegisterUser(UserBean registerUser) {
		String firstName=null;
		
		Connection con = null;
		Statement stmt = null;
		try {
			DatabaseConnection dbcon = DatabaseConnection.getInstance();
			con=dbcon.getConnection();
			stmt = con.createStatement();
			String sql;
			sql = "SELECT firstName FROM user where username=\""+registerUser.getUsername()+"\" and password=\"" + registerUser.getPassword()+"\"";
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				firstName = rs.getString("firstName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return firstName;
	}

	public void registerUser(UserBean registerUser) throws SQLException {
		
			DatabaseConnection dbcon = new DatabaseConnection();
			Connection con = dbcon.getConnection();
			Statement stmt = null;
	try {	
			stmt = con.createStatement();
			
			//verificam numarul de useri existenti pentru a seta id-ul la urmatoarea inserare
			String countUsersSql ="select count(*) as numarUseriExistenti from user";
		    ResultSet rs = stmt.executeQuery(countUsersSql);
		    String countUseriExistenti="0";
		    
		    while (rs.next()) {
		    	countUseriExistenti = rs.getString("numarUseriExistenti");
			}
		    
		    int idNextUser = Integer.parseInt(countUseriExistenti);
		    idNextUser++;
		    
		    String sqlInsertInDB = "INSERT INTO user VALUES ("+ idNextUser +", '"+ registerUser.getFirstName() +"', '"+registerUser.getLastName()+"', '"+registerUser.getUsername()+"','"+registerUser.getPassword()+"')";
		    
		    stmt.executeUpdate(sqlInsertInDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            con.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	}		
}