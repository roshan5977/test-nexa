package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Student;

public interface StudentService {
	public List<Student> getAllStudent();

	public Optional<Student> getStudentById(Long id);

	public Student createStudent(Student org);

	public Student updateStudent(Student org);

	public void deleteStudent(Long id);
}
