package com.Microservice.Customer.controller;


import com.Microservice.Customer.model.AuthenticationRequest;
import com.Microservice.Customer.model.AuthenticationResponse;
import com.Microservice.Customer.model.CustomerModel;
import com.Microservice.Customer.repository.CustomerRepository;
import com.Microservice.Customer.service.UserService;
import com.Microservice.Customer.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Customer")
public class AuthController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    //To Subscribe to the green car wash like register
    @PostMapping("/subs")
    private ResponseEntity<?> subscibeCarwasher(@RequestBody CustomerModel customer){
        String username = customer.getUsername();
        try {
            customerRepository.save(customer);
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
            return ResponseEntity.ok(new AuthenticationResponse("No"));
        }
        UserDetails loadedUser = userService.loadUserByUsername(username);
        String generatedToken = jwtUtil.generateToken(loadedUser);

        return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
    }}