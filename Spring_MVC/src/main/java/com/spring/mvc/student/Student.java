package com.spring.mvc.student;

import java.util.List;

public class Student {
	
	private Integer studentID; 
	private String name; 
	private Integer age;
	private String major; 
	private List<String> circle; 
	
	public Student() {
		
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<String> getCircle() {
		return circle;
	}

	public void setCircle(List<String> circle) {
		this.circle = circle;
	}
	
}
