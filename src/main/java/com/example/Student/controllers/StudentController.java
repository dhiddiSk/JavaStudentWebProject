package com.example.Student.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.dto.StudentDto;
import com.example.Student.entity.Student;
import com.example.Student.exceptions.BusinessException;
import com.example.Student.services.StudentsService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/students/")
public class StudentController {
	@Autowired
	StudentsService service;
	
	@PostMapping("/save/")
	public ResponseEntity<String> saveStudentsData(@RequestBody Student student) {		
		String responce = service.addStudents(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(responce);
	}
	
	@GetMapping("/get/{student_id}")
	public ResponseEntity<StudentDto> studentDetails(@PathVariable("student_id") Long student_id){
		Optional<Student> student = service.getStudentDetails(student_id);
		
		StudentDto sdto = new StudentDto();
		sdto.setCity(student.get().getCity());
		sdto.setCourse(student.get().getCourse());
		sdto.setEmail(student.get().getEmail());
		sdto.setGenderType(student.get().getGender());
		sdto.setName(student.get().getName());
		sdto.setPhoneNumber(student.get().getPhoneNumber());
		sdto.setRollNumber(student.get().getRollNumber());
		
		return ResponseEntity.status(HttpStatus.OK).body(sdto);
 	}
	
	@PutMapping("/update/{student_id}/{course}")
	public ResponseEntity<String> updateStudentsData(@PathVariable("student_id") Long student_id, @PathVariable("course") String course){	
		String responce = service.updateStudentCourse(student_id, course);
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}
	
	@GetMapping("get/name/{studentName}")
	public String returnStudentCourse(@PathVariable("studentName") String studentName){ 
		String responce = service.getStudentsCourse(studentName);
		return responce;
	}
	
	@DeleteMapping("/delete/student/{student_id}")
	public String deleteStudentRecord(@PathVariable("student_id") Long student_id) {
		if(student_id == 1) {
			throw new BusinessException("Please consider that, this is businessException");
		}
		String responce = service.deleteStudentRecord(student_id);
		return responce;
	}
}
