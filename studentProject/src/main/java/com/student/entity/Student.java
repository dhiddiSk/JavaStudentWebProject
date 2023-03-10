package com.student.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentID")
	private Long studentID;
	
	@Column(name = "firstName")
	private String firstName;
	
	public Student(Long studentID, String firstName, String lastName, String city, String rollNumber, String course,
			String email, String phoneNumber, Date dob, com.student.entity.Gender gender) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.rollNumber = rollNumber;
		this.course = course;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.Gender = gender;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", rollNumber=" + rollNumber + ", course=" + course + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", dob=" + dob + ", Gender=" + Gender + "]";
	}

	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "rollNumber")
	private String rollNumber;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "Gender")
	@Enumerated(EnumType.STRING)
	private Gender Gender;
	
	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return Gender;
	}

	public void setGender(Gender gender) {
		Gender = gender;
	}	
}
