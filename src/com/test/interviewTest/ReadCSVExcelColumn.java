package com.test.interviewTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadCSVExcelColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("StdAndNonStdSwListWithAliasUpdated.csv"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
