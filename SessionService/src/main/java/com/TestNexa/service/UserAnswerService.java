package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.UserAnswer;

public interface UserAnswerService {
	public List<UserAnswer> getAllUserAnswers();

	public Optional<UserAnswer> getUserAnswerById(Long id);

	public UserAnswer createUserAnswer(UserAnswer admin);

	public UserAnswer updateUserAnswer(UserAnswer admin);

	public void deleteUserAnswer(Long id);
}
