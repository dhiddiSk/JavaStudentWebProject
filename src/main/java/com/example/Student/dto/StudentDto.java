package com.example.Student.dto;

import com.example.Student.entity.GenderType;

public class StudentDto {
	
	private String name;
	private String city;
	private String rollNumber;
	private String course;
	private String email;
	private String phoneNumber;
	private GenderType GenderType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public GenderType getGenderType() {
		return GenderType;
	}
	public void setGenderType(GenderType genderType) {
		GenderType = genderType;
	}
}
