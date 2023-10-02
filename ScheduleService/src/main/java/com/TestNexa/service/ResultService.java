package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.Result;


public interface ResultService {
	public List<Result> getAllResults();

	public Optional<Result> getResultById(Long id);

	public Result createResults(Result options);

	public Result updateResults(Result options);

	public void deleteResults(Long id);
}
