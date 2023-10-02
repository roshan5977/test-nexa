package com.TestNexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.ScheduleExam;
import com.TestNexa.exception.ScheduleExamNotFoundException;
import com.TestNexa.service.ScheduleExamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scheduleexam")
public class ScheduleExamController {

    @Autowired
    private ScheduleExamService scheduleExamService;

    @PostMapping("/save")
    public ResponseEntity<ScheduleExam> saveScheduleExam(@RequestBody ScheduleExam scheduleExam) {
        return ResponseEntity.ok(scheduleExamService.createScheduleExams(scheduleExam));
    }

    @PutMapping("/update")
    public ResponseEntity<ScheduleExam> updateScheduleExam(@RequestBody ScheduleExam scheduleExam) {
        return ResponseEntity.ok(scheduleExamService.updateScheduleExams(scheduleExam));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteScheduleExam(@PathVariable Long id) {
        scheduleExamService.deleteScheduleExams(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ScheduleExam>> getAllScheduleExams() {
        return ResponseEntity.ok(scheduleExamService.getAllScheduleExams());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ScheduleExam> getScheduleExamById(@PathVariable Long id) {
        Optional<ScheduleExam> scheduleExamById = scheduleExamService.getScheduleExamById(id);
        if (!scheduleExamById.isPresent()) {
            throw new ScheduleExamNotFoundException("ScheduleExam not found");
        }
        return ResponseEntity.ok(scheduleExamById.get());
    }
}
