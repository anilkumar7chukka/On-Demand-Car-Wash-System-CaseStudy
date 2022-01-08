package com.Microservice.CarWasher.Controller;

import com.Microservice.CarWasher.model.AuthenticationRequest;
import com.Microservice.CarWasher.model.AuthenticationResponse;
import com.Microservice.CarWasher.model.IdGenerator;
import com.Microservice.CarWasher.model.WasherModel;
import com.Microservice.CarWasher.repository.IdRepository;
import com.Microservice.CarWasher.repository.WasherRepo;
import com.Microservice.CarWasher.services.UserService;
import com.Microservice.CarWasher.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Carwashers")
public class AuthController {

    @Autowired
    private WasherRepo carwasherrepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    IdRepository idRepo;

    //To Subscribe to the green car wash like register
    @PostMapping("/subs")
    private ResponseEntity<?> subscibeCarwasher(@RequestBody WasherModel carwasher){
        String username = carwasher.getUsername();
        try {
            carwasherrepository.save(carwasher);
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