package com.TestNexa.service;

import java.util.List;
import java.util.Optional;

import com.TestNexa.entity.UserSessionDetails;

public interface UserSessionDetailsService {
	public List<UserSessionDetails> getAllUserSessionDetails();

	public Optional<UserSessionDetails> getUserSessionDetailsById(Long id);

	public UserSessionDetails createUserSessionDetails(UserSessionDetails admin);

	public UserSessionDetails updateUserSessionDetails(UserSessionDetails admin);

	public void deleteUserSessionDetails(Long id);
}
