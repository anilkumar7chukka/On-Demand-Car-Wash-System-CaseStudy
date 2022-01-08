package com.Microservice.CarWasher.services;

import com.Microservice.CarWasher.model.WasherModel;
import com.Microservice.CarWasher.repository.WasherRepo;

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
    private WasherRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
        WasherModel foundedUser = userRepository.findByUsername(username);
        //if username is not there
        if (foundedUser == null) return null;

        String name = foundedUser.getUsername();
        String pwd = foundedUser.getPassword();
        return new User(name,pwd, new ArrayList<>());
    }
}
