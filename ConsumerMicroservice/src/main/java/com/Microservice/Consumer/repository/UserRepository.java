package com.Microservice.Consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.Consumer.model.UserModel;


@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
	
	UserModel findByUsername(String username);
	
}
