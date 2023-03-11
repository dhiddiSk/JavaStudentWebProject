package com.student.services;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	String addStudents(Student student);

	List<Student> getAllStudents();

}
