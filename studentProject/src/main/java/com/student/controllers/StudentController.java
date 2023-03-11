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

	@GetMapping("/get/student_id")
	public ResponseEntity<Optional<Student>> getStudentsData(@RequestParam("student_id") Long studentId) {
		Optional<Student> responce = service.getStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}
	
	@GetMapping("/get/student_name")
	public ResponseEntity<Optinoal<Student>> getStudentDataByName(@RequestParam("student_name") String student_name){
		Optional<Student> responce = service.getStudentDataWithName(student_name);
		return ResponseEntity.status(HttpStatus.OK).body(responce);		
	}

	@PutMapping("/update/course/{student_id}/{student_course}")
	public ResponseEntity<String> updateStudentData(@PathVariable("student_id") Long student_id, @PathVariable("student_course") String course)
	{
		String responce = service.updateStudentData(student_id, course);
		
		
		return null;
		
	}
	@DeleteMapping("/delete/{student_id}")
	public ResponseEntity<String> deleteStudentsData(@PathVariable("student_id") Long student_id){
		String responce = service.deleteStudents(student_id);
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}
	
	
	
}
