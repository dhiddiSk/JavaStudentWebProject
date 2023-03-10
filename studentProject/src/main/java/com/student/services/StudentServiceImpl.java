package com.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public String addStudents(Student student) {

		Student responce = studentRepo.save(student);

		if (responce == null) {
			return "The data is not saved";
		}
		return "The data got saved successfully";
	}

}
