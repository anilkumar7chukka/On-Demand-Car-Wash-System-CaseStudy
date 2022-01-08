package com.Microservice.Admin.service;


import com.Microservice.Admin.model.AdminModel;
import com.Microservice.Admin.repository.AdminRepository;

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
    private AdminRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
        AdminModel foundedUser = userRepository.findByUsername(username);
        //if username is not there
        if (foundedUser == null) return null;

        String name = foundedUser.getUsername();
        String pwd = foundedUser.getPassword();
        return new User(name,pwd, new ArrayList<>());
    }
}
