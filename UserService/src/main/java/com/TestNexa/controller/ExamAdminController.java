package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.ExamAdmin;
import com.TestNexa.exception.ExamAdminNotFoundException;
import com.TestNexa.service.ExamAdminService;

@RestController
@RequestMapping("/examadmin")
public class ExamAdminController {
    @Autowired
    private ExamAdminService examAdminService;

    @PostMapping("/save")
    public ResponseEntity<ExamAdmin> saveExamAdmin(@RequestBody ExamAdmin examAdmin) {
        return ResponseEntity.ok(examAdminService.createExamAdmin(examAdmin));
    }

    @PutMapping("/update")
    public ResponseEntity<ExamAdmin> updateExamAdmin(@RequestBody ExamAdmin examAdmin) {
        return ResponseEntity.ok(examAdminService.updateExamAdmin(examAdmin));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExamAdmin(@PathVariable Long id) {
        examAdminService.deleteExamAdmin(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExamAdmin>> getAllExamAdmins() {
        return ResponseEntity.ok(examAdminService.getAllExamAdmins());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ExamAdmin> getExamAdminById(@PathVariable Long id) {
        Optional<ExamAdmin> examAdminById = examAdminService.getExamAdminById(id);
        if (!examAdminById.isPresent()) {
            throw new ExamAdminNotFoundException("ExamAdmin not found");
        }
        return ResponseEntity.ok(examAdminById.get());
    }
}

