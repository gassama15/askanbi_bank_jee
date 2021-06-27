package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection cnx;
	private PreparedStatement pstmt;
	
	private static Database db;
	
	public static Database getInstance()
	{
		if(db == null)
		{
			db = new Database();
		}
		return db;
	}
	
	private Database() {}

	public Connection getCnx()
	{
		return cnx;
	}
	
	private void openConnection() throws Exception{
		
		try {
			if(cnx == null || cnx.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				
				String user = "root", password = "";
				String url = "jdbc:mysql://localhost:3306/askanbibank";
				
				cnx = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void myPrepareStatement(String sql) throws Exception {
		try {
			openConnection();
			pstmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void addParameters(Object[] parameters) throws SQLException {
		
		try {
			for(int i=0; i<parameters.length; i++) {
				pstmt.setObject(i + 1, parameters[i]);
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public ResultSet myExecuteQuery() throws Exception{
		try {
			return pstmt.executeQuery();
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public int myExecuteUpdate() throws Exception {
		try {
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public void closeConnection() throws Exception {
		try {
			pstmt.close();
			pstmt = null;
			cnx.close();
			cnx = null;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public int getLastInsertedId()
	{
		int value = 0;
		try {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				value = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}
		
	
}
