package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.Student;
import com.TestNexa.exception.StudentNotFoundException;
import com.TestNexa.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(student));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> studentById = studentService.getStudentById(id);
        if (!studentById.isPresent()) {
            throw new StudentNotFoundException("Student not found");
        }
        return ResponseEntity.ok(studentById.get());
    }
}
