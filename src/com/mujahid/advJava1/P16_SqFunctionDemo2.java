package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class P16_SqFunctionDemo2 {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			CallableStatement cst = con.prepareCall("{?= call getAllEmpInfo(?,?)}");
			cst.setInt(2, 1);
			cst.setInt(3, 4);
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet)cst.getObject(1);
			boolean flag= false;
			System.out.println("EmpID\tEName\tSal");
			System.out.println("------------------");
			while(rs.next()) {
				flag = true;
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
			}
			if(flag==false) {
				System.out.println("No Records Available");
			}
			
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
