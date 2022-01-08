package com.Microservice.Admin.service;

import com.Microservice.Admin.model.AdminModel;
import com.Microservice.Admin.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public String save(AdminModel adminModel){
        adminRepository.save(adminModel);
        return "Added";
    }
}
