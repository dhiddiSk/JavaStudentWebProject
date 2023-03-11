package com.student.services;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;

public interface StudentService {

	String addStudents(Student student);

	List<Student> getAllStudents();

	Optional<Student> getStudentData(Long studentId);
	
	String deleteStudents(Long studentId);

	String updateStudentData(Long student_id, String course);

	Optional<Student> getStudentDataWithName(String student_name);

}
