package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P11_PreventSqlInjectionAttack {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			String name = "saif";
		//	String name = "saif'--";
			int rollno = 3;
			String sqlQuery1 = "select * from students where NAME=? and ROLLNO=?";
			
		// incorrect query sqlQuery1 : select * from students where NAME='aijaz'--' and ROLLNO=4	
			
		//	String sqlQuery1 = "select * from students where NAME='aijaz' and ROLLNO=4";
		//	String sqlQuery1 = "select * from students";
			System.out.println("sqlQuery1 : "+sqlQuery1);

			PreparedStatement ps = con.prepareStatement(sqlQuery1);
			ps.setString(1, name);
			ps.setInt(2, rollno);
			
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				System.out.println("entered, and has some resultset");
				System.out.println("Roll No : "+rs.getInt("ROLLNO")+", Name :"+ rs.getString("NAME"));
			}
			
			/*
			 * if(!rs.next()) { System.out.
			 * println("Sorry, i don't find any results. Please check the entered values");
			 * }
			 */
			
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
