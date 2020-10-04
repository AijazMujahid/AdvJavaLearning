package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P9_PreparedStDynamicQuery {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			/*
			 * String sqlQuery1 = "insert into students values(?,?)"; PreparedStatement pst
			 * = con.prepareStatement(sqlQuery1);
			 * 
			 * pst.setInt(1, 5); pst.setString(2, "test");
			 * 
			 * int updateCount = pst.executeUpdate();
			 * System.out.println("no of rows inserted : "+updateCount);
			 */
		
		//	String sqlQuery1 = "delete from students where ROLLNO=?";
			String sqlQuery1 = "delete from students where NAME=?";
			PreparedStatement pst = con.prepareStatement(sqlQuery1);
			
		//	pst.setInt(1, 1);
			pst.setString(1, "mujahid");

			int updateCount = pst.executeUpdate();
			System.out.println("no of rows deleted : "+updateCount);
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		}
		
	}

}
