package br.com.portal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/portal_study";
		String user = "root";
		String password = "";
		
		try {
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 public static void close(Connection connection) {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException var2) {
	            var2.printStackTrace();
	        }

	    }

	    public static void close(Connection connection, PreparedStatement pst) {
	        close(connection);

	        try {
	            if (pst != null) {
	                pst.close();
	            }
	        } catch (SQLException var3) {
	            var3.printStackTrace();
	        }

	    }

	    public static void close(Connection connection, PreparedStatement pst, ResultSet rs) {
	        close(connection, pst);

	        try {
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException var4) {
	            var4.printStackTrace();
	        }

	    }
	
	

}
