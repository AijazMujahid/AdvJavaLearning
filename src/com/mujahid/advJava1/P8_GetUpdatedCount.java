package com.mujahid.advJava1;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P8_GetUpdatedCount {

	public static void main(String[] args) {

		Connection con = null;
		
		try {
			con = new JdbcConnection().getConnectionObject();
			Statement st = con.createStatement();

			String updateAllQ = "update students set name ='Saira'";
			
			boolean b = st.execute(updateAllQ);
			System.out.println(b);
			
			if(b==true) {
				ResultSet rs = st.getResultSet();
				while(rs.next()) {
					System.out.println("Has some resultSet");
				}
			}else {
				int rowCount = st.getUpdateCount();
				System.out.println("The number of records effected is :"+rowCount);
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
