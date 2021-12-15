package com.Microservice.Consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.Consumer.model.AuthenticationRequest;
import com.Microservice.Consumer.model.AuthenticationResponse;
import com.Microservice.Consumer.model.UserModel;
import com.Microservice.Consumer.repository.ConsumerRepository;
import com.Microservice.Consumer.repository.UserRepository;
import com.Microservice.Consumer.service.UserService;
import com.Microservice.Consumer.util.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private ConsumerRepository carwasherrepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
//To Subscribe to the green car wash like register
	//To Subscribe to the green car wash like register
		@PostMapping("/subs")
		private ResponseEntity<?> subscibeCustomer(@RequestBody AuthenticationRequest authenticationRequest){
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();
		
			UserModel userModel = new UserModel();
			userModel.setUsername(username);
			userModel.setPassword(password);
			
			try {
				userRepository.save(userModel);
			} catch (Exception e) {
				return ResponseEntity.ok(new AuthenticationResponse("Error creating user with username: "+ username));
			}
			return ResponseEntity.ok(new AuthenticationResponse("Created user with username: "+ username));
		}
		
	//For authentication
		@PostMapping("/auth")
		private ResponseEntity<?> authenticateCustomer(@RequestBody AuthenticationRequest authenticationRequest){
			String username = authenticationRequest.getUsername();
			String password = authenticationRequest.getPassword();
			
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			}catch(Exception e) {
				return ResponseEntity.ok(new AuthenticationResponse("No user found with username: "+ username));
			}
			UserDetails loadedUser =userService.loadUserByUsername(username);
			String generatedToken = jwtUtil.generateToken(loadedUser);
			
			return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		}}