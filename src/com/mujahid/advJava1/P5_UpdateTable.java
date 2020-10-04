package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class P5_UpdateTable {

	public static void main(String[] args) {

		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con1 = null;
		
		try {
			con1 = JdbcClassObject.getConnectionObject();
			Statement st = con1.createStatement();
			System.out.println("before");
			String updateQuery = "update covid_patients set patient='def' where serialNo='4'";
			
			int rowsUpdated = st.executeUpdate(updateQuery);
			System.out.println("after");
			System.out.println(rowsUpdated+" rows updated");
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
