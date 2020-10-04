package com.mujahid.advJava1;

// select count(*) from employees;

import java.sql.*;

public class JdbcConnection {
	
	public static Connection con = null;
	
	public static Connection getConnectionObject() throws SQLException{
		//Connection con = null;
		try	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			System.out.println("Connection Object : "+con);
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		/*
		 * finally { con.close(); }
		 */
		return con;
	}

	/*
	 * public static void main(String[] args) { JdbcConnection JdbcClassObject = new
	 * JdbcConnection(); try { con = JdbcClassObject.getConnectionObject(); } catch
	 * (SQLException e) { e.printStackTrace(); } }
	 */


}
