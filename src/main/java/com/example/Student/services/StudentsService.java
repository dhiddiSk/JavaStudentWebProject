package com.example.Student.services;
import java.util.List;
import java.util.Optional;
import com.example.Student.entity.Student;

public interface StudentsService {
	public String addStudents(Student student);
	public List<Student> getAllStudentsRecors();
	public String removeStudents(int id);
	public Optional<Student> getStudentDetails(Long id);
	public String updateStudentCourse(Long student_id, String course);
	public String getStudentsCourse(String studentName);
	public String deleteStudentRecord(Long student_id);
}
