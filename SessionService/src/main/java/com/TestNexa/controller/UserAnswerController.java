package com.TestNexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.TestNexa.entity.UserAnswer;
import com.TestNexa.exception.UserAnswerNotFoundException;
import com.TestNexa.service.UserAnswerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/useranswer")
public class UserAnswerController {
	@Autowired
	private UserAnswerService userAnswerService;

	@PostMapping("/save")
	public ResponseEntity<UserAnswer> saveUserAnswer(@RequestBody UserAnswer userAnswer) {
		return ResponseEntity.ok(userAnswerService.createUserAnswer(userAnswer));
	}

	@PutMapping("/update")
	public ResponseEntity<UserAnswer> updateUserAnswer(@RequestBody UserAnswer userAnswer) {
		return ResponseEntity.ok(userAnswerService.updateUserAnswer(userAnswer));
	}

	@DeleteMapping("/delete/{id}")
	public String deleteUserAnswer(@PathVariable Long id) {
		userAnswerService.deleteUserAnswer(id);
		return id + " Deleted Successfully";
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserAnswer>> getAllUserAnswers() {
		List<UserAnswer> userAnswers = userAnswerService.getAllUserAnswers();
		return ResponseEntity.ok(userAnswers);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<UserAnswer> getUserAnswerById(@PathVariable Long id) {
		Optional<UserAnswer> userAnswerById = userAnswerService.getUserAnswerById(id);
		if (userAnswerById.isPresent()) {
			return ResponseEntity.ok(userAnswerById.get());
		} else {
			throw new UserAnswerNotFoundException("UserAnswer not found");
		}
	}
}
