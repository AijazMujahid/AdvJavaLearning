package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class P15_SqlFunctionDemo1 {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			CallableStatement cst = con.prepareCall("{?= call getAvgSal(?,?)}");
			
			cst.setInt(2, 3);
			cst.setInt(3, 4);
			
			cst.registerOutParameter(1, Types.FLOAT);
			cst.execute();
			System.out.println("Avg Salary : "+cst.getFloat(1));
			
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
