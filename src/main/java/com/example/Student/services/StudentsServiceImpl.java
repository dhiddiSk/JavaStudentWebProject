package com.example.Student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Student.entity.Student;
import com.example.Student.repositories.StudentRepository;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public String addStudents(Student student) {
		Student responce = studentRepo.save(student);
		if (responce == null) {
			return "The data sent to server is empty";
		}
		return "The data has been saved succesfully";
	}

	@Override
	public List<Student> getAllStudentsRecors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeStudents(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> getStudentDetails(Long id) {
		Optional<Student> studentsWithId = studentRepo.findById(id);
		return studentsWithId;
	}

	@Override
	public String updateStudentCourse(Long student_id, String course) {
		Optional<Student> studentObject = studentRepo.findById(student_id);
		studentObject.get().setCourse(course);
		studentRepo.save(studentObject.get());
		return "updated successfully";
	}
  
  @Override
	public String getStudentsCourse(String studentName) {
		String course = studentRepo.getByCourse(studentName);
		return course;
	}

	@Override
	public String deleteStudentRecord(Long student_id) {
		Optional<Student> studentObject = studentRepo.findById(student_id);
		studentRepo.delete(studentObject.get());
		return "successfully deleted";
		
	}
}
