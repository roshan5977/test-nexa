package com.TestNexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.UserSessionDetails;
import com.TestNexa.exception.UserSessionDetailsNotFoundException;
import com.TestNexa.service.UserSessionDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usersessiondetails")
public class UserSessionDetailsController {
    @Autowired
    private UserSessionDetailsService userSessionDetailsService;

    @PostMapping("/save")
    public ResponseEntity<UserSessionDetails> saveUserSessionDetails(@RequestBody UserSessionDetails userSessionDetails) {
        return ResponseEntity.ok(userSessionDetailsService.createUserSessionDetails(userSessionDetails));
    }

    @PutMapping("/update")
    public ResponseEntity<UserSessionDetails> updateUserSessionDetails(@RequestBody UserSessionDetails userSessionDetails) {
        return ResponseEntity.ok(userSessionDetailsService.updateUserSessionDetails(userSessionDetails));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserSessionDetails(@PathVariable Long id) {
        userSessionDetailsService.deleteUserSessionDetails(id);
        return id + " Deleted Successfully";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserSessionDetails>> getAllUserSessionDetails() {
        List<UserSessionDetails> userSessionDetailsList = userSessionDetailsService.getAllUserSessionDetails();
        return ResponseEntity.ok(userSessionDetailsList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserSessionDetails> getUserSessionDetailsById(@PathVariable Long id) {
        Optional<UserSessionDetails> userSessionDetailsById = userSessionDetailsService.getUserSessionDetailsById(id);
        if (userSessionDetailsById.isPresent()) {
            return ResponseEntity.ok(userSessionDetailsById.get());
        } else {
            throw new UserSessionDetailsNotFoundException("UserSessionDetails not found");
        }
    }
}
