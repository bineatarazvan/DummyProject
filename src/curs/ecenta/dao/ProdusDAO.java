package curs.ecenta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import curs.ecenta.beans.ProdusBean;
import curs.ecenta.beans.UserBean;
import curs.ecenta.databaseConnection.DatabaseConnection;

public class ProdusDAO {
	public ArrayList<ProdusBean> GetProducts(){
		ArrayList<ProdusBean> products = new ArrayList<>();
		
		Connection con = null;
		Statement stmt = null;
		try {
			DatabaseConnection dbcon = DatabaseConnection.getInstance();
			con=dbcon.getConnection();
			stmt = con.createStatement();
			String sql;
			sql = "SELECT * FROM produs";
			ResultSet rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				ProdusBean produs = new ProdusBean();
				produs.setIdprodus(rs.getInt("idprodus"));			//setIduser(rs.getInt("iduser"));
				produs.setDen_produs(rs.getString("den_produs"));
				produs.setPret_produs(rs.getInt("pret_produs"));
				produs.setAlte_informati(rs.getString("alte_informatii"));
				produs.setLink(rs.getString("link"));
				products.add(produs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}
