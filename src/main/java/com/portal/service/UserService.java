package com.portal.service;

import java.util.*;

import com.portal.model.User;

public interface UserService {

	public List<User> getAllUsers();

	public Optional<User> getUserById(Long id);

	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long id);

}
