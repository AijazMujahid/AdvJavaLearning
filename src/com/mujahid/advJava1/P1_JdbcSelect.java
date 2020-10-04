package com.mujahid.advJava1;

import java.sql.*;
import java.util.ArrayList;

import com.mujahid.model.Student;

public class P1_JdbcSelect {

	public static void main(String[] args) throws SQLException {
		
		JdbcConnection JdbcClassObject = new JdbcConnection();
		Connection con = null;
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		try {
			con = JdbcClassObject.getConnectionObject();
			
			Statement st = con.createStatement();
			String sql = "select * from students";

			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student();
				s.setRollNo(rs.getInt("ROLLNO"));
				s.setName(rs.getString("NAME"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	catch (Exception e) {
			e.printStackTrace();
		}finally { con.close(); }
		
		System.out.println("Check Connection Object : "+con);
		
		if(studentList.size()>0) {
			for(Student s: studentList) {
				s.displayStudentInfo(s);
			}
		}

	}

}
