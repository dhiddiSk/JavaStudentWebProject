package com.student.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.annotations.GwtCompatible;
import com.student.entity.Student;
import com.student.services.StudentService;

@RestController
@RequestMapping("/students/")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/save/")
	public ResponseEntity<String> saveStudentsData(@RequestBody Student student) {
		String responce = service.addStudents(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(responce);
	}

	@GetMapping("/get-all/")
	public ResponseEntity<List<Student>> studentsData() {

		List<Student> responce = service.getAllStudents();

		return ResponseEntity.status(HttpStatus.OK).body(responce);

	}

	@GetMapping("/get/{student_id}")
	public ResponseEntity<Optional<Student>> getStudentsData(@PathVariable("student_id") Long studentId) {
		// Perform the operation, then fetch the data from the repo, then send it to the
		// postman
		Optional<Student> responce = service.getStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

//	@PutMapping()
//	
//	@DeleteMapping()
//	

}
