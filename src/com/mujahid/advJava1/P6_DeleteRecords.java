package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class P6_DeleteRecords {

	public static void main(String[] args) {

		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con1 = null;
		
		try {
			con1 = JdbcClassObject.getConnectionObject();
			Statement st = con1.createStatement();
			System.out.println("before");
//			String deleteQuery = "delete from covid_patients where serialNo=3";
			int serialNo = 4; 
			String deleteQuery = String.format("delete from covid_patients where serialNo=%d", serialNo);		
			int rowsUpdated = st.executeUpdate(deleteQuery);
			System.out.println("after");
			System.out.println(rowsUpdated+" rows deleted");
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}


	}

}
