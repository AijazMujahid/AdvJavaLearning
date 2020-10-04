package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_DropTable {

	public static void main(String[] args) {

		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con1 = null;
		
		try {

			con1 = JdbcClassObject.getConnectionObject();
			Statement st = con1.createStatement();
			String createTableQuery = "drop table covid_patients";
			st.executeUpdate(createTableQuery);
			
			System.out.println("covid_patients table deleted/dropped");
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
