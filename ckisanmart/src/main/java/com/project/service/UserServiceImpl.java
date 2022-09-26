package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojo.User;
import com.project.repository.IUserRepository;
@Service
@Transactional
public class UserServiceImpl implements IUserServices {

	@Autowired
	private IUserRepository iUserRepo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private  EmailSenderService mailservice;
	@Override
	public Optional<User> getUser(String email) {
		
		return iUserRepo.findByEmail(email);
	}
	@Override
	public User registerUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
	return iUserRepo.save(user);
		
	}
	@Override
	public int validateEmailAndGenearateOtp(String email) {
		int randomNumber;
		if(iUserRepo.findByEmail(email).isPresent()) {
			randomNumber=(int)(Math.random()*9999);
			if(randomNumber<=1000) {
				randomNumber=randomNumber+1000;
			}
			mailservice.sendMail(email,"otp password Reset",String.valueOf(randomNumber));
			return randomNumber; 
		
	}
		else {
			return -1;
		}
}
	@Override
	public boolean changePassword(String email, String password) {
		User u=iUserRepo.findByEmail(email).orElseThrow();
		u.setPassword(encoder.encode(password));
		if(iUserRepo.save(u)!=null)
			return true;
		return false;
	}
}