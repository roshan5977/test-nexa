package com.TestNexa.controller;

import java.util.List;

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

import com.TestNexa.entity.Result;
import com.TestNexa.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;


    @PostMapping("/save")
    public ResponseEntity<Result> saveResult(@RequestBody Result result) {
        // Implement the logic to save a result using the resultService
        return ResponseEntity.ok(resultService.createResults(result));
    }

    @PutMapping("/update")
    public ResponseEntity<Result> updateResult(@RequestBody Result result) {
        // Implement the logic to update a result using the resultService
        return ResponseEntity.ok(resultService.updateResults(result));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteResult(@PathVariable Long id) {
        // Implement the logic to delete a result using the resultService
        resultService.deleteResults(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Result>> getAllResults() {
        // Implement the logic to get all results using the resultService
        return ResponseEntity.ok(resultService.getAllResults());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        // Implement the logic to get a result by ID using the resultService
        return ResponseEntity.ok(resultService.getResultById(id).orElse(null));
    }
}
