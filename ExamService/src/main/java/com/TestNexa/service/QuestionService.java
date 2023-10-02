package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Question;

public interface QuestionService {

	public List<Question> getAllQuestions();

	public Optional<Question> getQuestionsById(Long id);

	public Question createQuestions(Question question);

	public Question updateQuestions(Question question);

	public void deleteQuestions(Long id);
}
