package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojo.User;
import com.project.repository.IUserRepository;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Invalid Email ID"));
		if(user==null) {
			throw new UsernameNotFoundException(username+"not found");
		}
		return new CustomUserDetails(user);
	}
	
	

}
