package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class P2_CreateTable {

	public static void main(String[] args) {

		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con1 = null;
		
		try {

			con1 = JdbcClassObject.getConnectionObject();
			Statement st = con1.createStatement();
			String createTableQuery = "create table covid_patients(serialNo number,patient varchar2(20))";
			st.executeUpdate(createTableQuery);
			
			System.out.println("covid_patients table created");
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
