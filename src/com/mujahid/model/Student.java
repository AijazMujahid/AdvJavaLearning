package com.mujahid.model;

public class Student {
	
	private int rollNo;
	private String name;
	
	public Student(){
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public Student(int rollNo,String name){
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void displayStudentInfo(Student s) {
		System.out.println("Name : "+s.name+" , Roll No. : "+s.rollNo);
	}
}
