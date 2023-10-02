package com.TestNexa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TestNexa.entity.Question;
import com.TestNexa.exception.QuestionNotFoundException;
import com.TestNexa.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.createQuestions(question));
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.updateQuestions(question));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestions(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> questionById = questionService.getQuestionsById(id);
        if (!questionById.isPresent()) {
            throw new QuestionNotFoundException("Question not found");
        }
        return ResponseEntity.ok(questionById.get());
    }
}
