package com.mujahid.util;

import java.sql.*;

public class CleanUpConnection {
	
	public void closeConnection(Connection con) {

			try {
				con.close();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
	}	
}
