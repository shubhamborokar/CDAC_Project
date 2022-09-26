package com.project.service;

import java.util.Optional;

import com.project.pojo.User;

public interface IUserServices {
	public Optional<User> getUser(String email);

	public User registerUser(User user);

	 int validateEmailAndGenearateOtp(String email);

	 boolean changePassword(String email, String password);
}
