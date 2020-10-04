package com.mujahid.advJava1;

public class P20_SqlDateAndUtilDateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date uDate = new java.util.Date();
		System.out.println("Util Date : "+uDate);
		long l = uDate.getTime();
		System.out.println("Util Date in l : "+l);
		java.sql.Date sDate = new java.sql.Date(l);
		System.out.println("Sql Date : "+sDate);
		
	//	java.sql also has time class to represent Time values and TimeStamp class to represent both Date and Time
	//	java.sql.Time t = new java.sql.Time(l);
	//	java.sql.Timestamp ts = new java.sql.Timestamp(l);
	}

}
