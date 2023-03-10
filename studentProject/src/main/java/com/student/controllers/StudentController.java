package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
