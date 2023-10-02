package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.UserAnswer;
import com.TestNexa.exception.UserAnswerNotFoundException;
import com.TestNexa.repository.UserAnswerRepository;
import com.TestNexa.service.UserAnswerService;

@Service
public class UserAnswerServiceImplementation implements UserAnswerService {

	@Autowired
	private UserAnswerRepository userAnswerRepository;

	@Override
	public List<UserAnswer> getAllUserAnswers() {
		List<UserAnswer> userAnswers = userAnswerRepository.findAll();
		if (userAnswers.isEmpty()) {
			throw new UserAnswerNotFoundException("No user answers found.");
		}
		return userAnswers;
	}

	@Override
	public Optional<UserAnswer> getUserAnswerById(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid user answer ID");
		}
		Optional<UserAnswer> userAnswer = userAnswerRepository.findById(id);
		if (!userAnswer.isPresent()) {
			throw new UserAnswerNotFoundException("User answer not found with ID: " + id);
		}
		return userAnswer;
	}

	@Override
	public UserAnswer createUserAnswer(UserAnswer userAnswer) {
		if (userAnswer == null) {
			throw new IllegalArgumentException("User answer cannot be null");
		}
		// Add any validation logic for the 'userAnswer' object here.
		UserAnswer createdUserAnswer = userAnswerRepository.save(userAnswer);
		if (createdUserAnswer == null) {
			throw new RuntimeException("Failed to create user answer");
		}
		return createdUserAnswer;
	}

	@Override
	public UserAnswer updateUserAnswer(UserAnswer userAnswer) {
		if (userAnswer == null || userAnswer.getUser_answer_id() == null) {
			throw new IllegalArgumentException("User answer or ID cannot be null");
		}
		Optional<UserAnswer> existingUserAnswer = userAnswerRepository.findById(userAnswer.getUser_answer_id());
		if (!existingUserAnswer.isPresent()) {
			throw new UserAnswerNotFoundException("User answer not found with ID: " + userAnswer.getUser_answer_id());
		}
		UserAnswer updatedUserAnswer = userAnswerRepository.save(userAnswer);
		if (updatedUserAnswer == null) {
			throw new RuntimeException("Failed to update user answer");
		}
		return updatedUserAnswer;
	}

	@Override
	public void deleteUserAnswer(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid user answer ID");
		}
		Optional<UserAnswer> existingUserAnswer = userAnswerRepository.findById(id);
		if (!existingUserAnswer.isPresent()) {
			throw new UserAnswerNotFoundException("User answer not found with ID: " + id);
		}
		try {
			this.userAnswerRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Failed to delete user answer with ID: " + id, e);
		}
	}
}
