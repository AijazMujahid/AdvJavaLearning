package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mujahid.model.Student;

public class P4_DynamicQueryInput {

	public static void main(String[] args) {
		
		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con1 = null;
		
		/*
		 * Student s1 = new Student(2,"kutta"); Student s3 = new Student(3,"harami");
		 */
		
		int serialNo = 4;
		String patient = "manhoos";
		
		try {

			con1 = JdbcClassObject.getConnectionObject();
			Statement st = con1.createStatement();
//	String inserQuery = "insert into covid_patients values("+rollNo+",'"+name+"')";
			
			String insertQuery = String.format("insert into covid_patients values(%d,'%s')", serialNo,patient);
			int rowsAdded = st.executeUpdate(insertQuery);
			
			System.out.println(rowsAdded+" row added");
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
