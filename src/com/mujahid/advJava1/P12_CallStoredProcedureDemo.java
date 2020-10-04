package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class P12_CallStoredProcedureDemo {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			CallableStatement cst = con.prepareCall("{call SUMPROCEDURE(?,?,?)}");
			cst.setInt(1, 10);
			cst.setInt(2, 20);
			cst.registerOutParameter(3, Types.INTEGER);
			
			cst.execute();
			
			int result = cst.getInt(3);
			
			System.out.println("SUM Procedure got executed and its result is : "+result);
			
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
