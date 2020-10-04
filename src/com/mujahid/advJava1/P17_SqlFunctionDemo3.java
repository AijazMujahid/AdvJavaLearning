package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class P17_SqlFunctionDemo3 {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			CallableStatement cst = con.prepareCall("{?=call getDeletedEmpInfo(?,?)}");
			cst.setInt(2, 2);
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.registerOutParameter(3, Types.INTEGER);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(1);
			System.out.println("EmpID\tEName\tSal");
			System.out.println("------------------");
			while(rs.next()) {

				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
			}
			//System.out.println(cst.getInt(3));
			int count = cst.getInt(3);
			System.out.println("The number of rows deleted : "+count);

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
