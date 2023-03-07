package com.example.Student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(value = "select course from student_table where name=:studentName", nativeQuery = true)
	String getByCourse(String studentName);
}
