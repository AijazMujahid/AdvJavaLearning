package com.mujahid.advJava1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P21_SimpleDateFormatDemo {

public static void main(String[] args) {
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter DOB(DD-MON-YYYY)");
		String DOB = sc.next();*/
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/YYYY");
		String strDate = formatter.format(date);
		System.out.println("Date format with DD/MM/YYYY : "+strDate);
		
		formatter = new SimpleDateFormat("MMM-dd-YYYY");
		String strDate2 = formatter.format(date);
		System.out.println("Date format with MMM-dd-YYYY : "+strDate2);

	}

}
