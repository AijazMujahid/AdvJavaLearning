package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class P14_SYS_REFCURSOR_Demo2 {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			CallableStatement cst = con.prepareCall("{call getEmpInfoByName(?,?)}");
			cst.setString(1, "s%");
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			
			ResultSet rs = (ResultSet)cst.getObject(2);
			boolean flag = false;
			
			System.out.println("RollNo\tName");
			System.out.println("------  -------");
			while(rs.next()) {
				flag = true;
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
			
			if(flag==false) {
				System.out.println("No records available");
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
