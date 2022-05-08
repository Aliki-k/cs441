package data;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {



	/**
	 * This program demonstrates how to establish database connection to Microsoft
	 * SQL Server.
	 * @author www.codejava.net
	 *
	 */


	public static void main(String[] args) {
		
		Connection conn = null;

		try {
			//Class.forName("com.mysql.jdbc.Driver");  
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String dbURL = "jdbc:mysql://localhost:3306";
			String user = "root";
			String pass = "abcd1234";
			conn = DriverManager.getConnection(dbURL,user,pass);
			if (conn != null) {
				System.out.println("MMMMMMM");
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

}



