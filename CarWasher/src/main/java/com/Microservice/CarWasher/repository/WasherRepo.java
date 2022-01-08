package com.Microservice.CarWasher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.CarWasher.model.WasherModel;

public interface WasherRepo extends MongoRepository<WasherModel, Integer> {
    WasherModel findByUsername(String username);
}
