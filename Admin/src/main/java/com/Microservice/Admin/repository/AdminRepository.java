package com.Microservice.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Admin.model.AdminModel;

public interface AdminRepository extends MongoRepository<AdminModel,String> {
    AdminModel findByUsername(String username);
}
