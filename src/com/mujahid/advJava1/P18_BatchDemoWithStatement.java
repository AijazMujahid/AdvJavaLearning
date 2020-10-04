package com.mujahid.advJava1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.OracleTypes;

public class P18_BatchDemoWithStatement {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			Statement st = con.createStatement();
			//st.addBatch("select * from emp");
			st.addBatch("insert into emp values(2,'mujahid',6442342)");
			st.addBatch("insert into emp values(5,'simran',4342342)");
			st.addBatch("insert into emp values(6,'tazreen',643523)");
			st.addBatch("insert into emp values(7,'mom',6442342)");
			int[] count = st.executeBatch();
			int updateCount = 0;
			for(int x: count) {
				updateCount = updateCount + x;
			}

			System.out.println("the no of rows udpated : "+updateCount);
			
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
