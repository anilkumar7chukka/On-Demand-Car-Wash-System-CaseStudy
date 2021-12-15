package com.Microservice.Consumer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Microservice.Consumer.model.UserModel;
import com.Microservice.Consumer.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//find the user name
		UserModel foundedUser = userRepository.findByUsername(username);
		//if username is not there
		if (foundedUser == null) return null;
		
		String name = foundedUser.getUsername();
		String pwd = foundedUser.getPassword();
		return new User(name, pwd, new ArrayList<>());
	}
}