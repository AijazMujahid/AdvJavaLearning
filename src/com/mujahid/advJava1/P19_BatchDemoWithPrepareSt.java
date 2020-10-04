package com.mujahid.advJava1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class P19_BatchDemoWithPrepareSt {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			
			PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Enter EmpID");
				int empId = sc.nextInt();
				System.out.println("Enter EmpName");
				String empName = sc.next();
				System.out.println("Enter EmpSal");
				double empSal = sc.nextDouble();
				pst.setInt(1, empId);
				pst.setString(2, empName);
				pst.setDouble(3, empSal);
				pst.addBatch();
				System.out.println("Do you want to insert one more record[Yes/No]:");
				String option = sc.next();
				if(option.equalsIgnoreCase("No")) {
					break;
				}
			}
			pst.executeBatch();
			System.out.println("Records inserted Successfully");
			
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
