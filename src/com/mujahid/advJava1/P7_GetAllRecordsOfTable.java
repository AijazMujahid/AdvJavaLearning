package com.mujahid.advJava1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class P7_GetAllRecordsOfTable {

	public static void main(String[] args) throws IOException {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			Statement st = con.createStatement();
			String getAllRecordsQ = "select * from employees";
			
			ResultSet rs = st.executeQuery(getAllRecordsQ);
			String data = "";
			data = data+"<html><body><center><table border='1' bgcolor='green'>";
data=data+"<tr><td>EMPLOYEE ID</td><td>FIRST NAME</td><td>LAST NAME</td><td>SALARY</td><td>PHONE NUMBER</td></tr>";
			while(rs.next()) {
				data = data +"<tr>"+
						"<td>"+rs.getInt(1)+"</td>"+
						"<td>"+rs.getString(2)+"</td>"+
						"<td>"+rs.getString(3)+"</td>"+
						"<td>"+rs.getDouble(8)+"</td>"+
						"<td>"+rs.getString(5)+"</td>"+
						"</tr>";
			}
			data=data+"</table><center></body></html>";
			FileOutputStream fos = new FileOutputStream("emp.html");
			byte[] b = data.getBytes();
			fos.write(b);
			fos.flush();
			System.out.println("Open emp.html to get Employees data");
			fos.close();
			con.close();
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}

	}

}
