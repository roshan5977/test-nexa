package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.Student;
import com.TestNexa.exception.StudentNotFoundException;
import com.TestNexa.repository.StudentRepository;
import com.TestNexa.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid student ID");
        }

        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return student;
    }

    @Override
    public Student createStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student can't be null");
        }

        Student createdStudent = studentRepository.save(student);

        if (createdStudent == null) {
            throw new RuntimeException("Failed to create student");
        }

        return createdStudent;
    }

    @Override
    public Student updateStudent(Student student) {
        if (student == null || student.getS_id() == null) {
            throw new IllegalArgumentException("Student or ID cannot be null");
        }

        Optional<Student> existingStudent = studentRepository.findById(student.getS_id());

        if (!existingStudent.isPresent()) {
            throw new StudentNotFoundException("Student not found with ID: " + student.getS_id());
        }

        Student updatedStudent = studentRepository.save(student);

        if (updatedStudent == null) {
            throw new RuntimeException("Failed to update student");
        }

        return updatedStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        if (id == null || id <= 0) {
            throw  new IllegalArgumentException("Invalid student ID");
        }

        Optional<Student> existingStudent = studentRepository.findById(id);

        if (!existingStudent.isPresent()) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        try {
            this.studentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete student with ID: " + id, e);
        }
    }
}
