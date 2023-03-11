package com.student.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Student> getAllStudents() {

		List<Student> responceFromRepo = studentRepo.findAll();
		System.out.println(responceFromRepo);

		return responceFromRepo;
	}

	@Override
	public Optional<Student> getStudentData(Long studentId) {
		Optional<Student> responce = studentRepo.findById(studentId);
		return responce;
	}

}
