package com.Microservice.Customer.service;


import com.Microservice.Customer.model.CustomerModel;
import com.Microservice.Customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CustomerRepository  customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
        CustomerModel foundedUser = customerRepository.findByUsername(username);
        //if username is not there
        if (foundedUser == null) return null;

        String name = foundedUser.getUsername();
        String pwd = foundedUser.getPassword();
        return new User(name,pwd, new ArrayList<>());
    }
}
