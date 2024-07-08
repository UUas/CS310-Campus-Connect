package com.sabanciuniv.payload;

public class UserPayload {
	
	private String userName;
	private String name;
	private String surName;
	private String studentClub;
	private String password;
	private int age;
	private String faculty;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getStudentClub() {
		return studentClub;
	}
	public void setStudentClub(String studentClub) {
		this.studentClub = studentClub;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public UserPayload(String userName, String name, String surName, String studentClub, String password, int age,
			String faculty) {
		super();
		this.userName = userName;
		this.name = name;
		this.surName = surName;
		this.studentClub = studentClub;
		this.password = password;
		this.age = age;
		this.faculty = faculty;
	}
	public UserPayload() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
