package com.TestNexa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestNexa.entity.Result;
import com.TestNexa.exception.ResultNotFoundException;
import com.TestNexa.repository.ResultRepository;
import com.TestNexa.service.ResultService;

@Service
public class ResultServiceImplementation implements ResultService {

	@Autowired
	private ResultRepository resultRepository;

	@Override
	public List<Result> getAllResults() {
		List<Result> results = resultRepository.findAll();
		if (results.isEmpty()) {
			throw new ResultNotFoundException("No results found.");
		}
		return results;
	}

	@Override
	public Optional<Result> getResultById(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid result ID");
		}
		Optional<Result> result = resultRepository.findById(id);
		if (!result.isPresent()) {
			throw new ResultNotFoundException("Result not found with ID: " + id);
		}
		return result;
	}

	@Override
	public Result createResults(Result result) {
		if (result == null) {
			throw new IllegalArgumentException("Result cannot be null");
		}
		// Add any validation logic for the 'result' object here.
		Result createdResult = resultRepository.save(result);
		if (createdResult == null) {
			throw new RuntimeException("Failed to create result");
		}
		return createdResult;
	}

	@Override
	public Result updateResults(Result result) {
		if (result == null || result.getRes_id() == null) {
			throw new IllegalArgumentException("Result or ID cannot be null");
		}
		Optional<Result> existingResult = resultRepository.findById(result.getRes_id());
		if (!existingResult.isPresent()) {
			throw new ResultNotFoundException("Result not found with ID: " + result.getRes_id());
		}
		Result updatedResult = resultRepository.save(result);
		if (updatedResult == null) {
			throw new RuntimeException("Failed to update result");
		}
		return updatedResult;
	}

	@Override
	public void deleteResults(Long id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid result ID");
		}
		Optional<Result> existingResult = resultRepository.findById(id);
		if (!existingResult.isPresent()) {
			throw new ResultNotFoundException("Result not found with ID: " + id);
		}
		try {
			this.resultRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Failed to delete result with ID: " + id, e);
		}
	}
}
