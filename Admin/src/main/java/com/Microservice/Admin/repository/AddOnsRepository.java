package com.Microservice.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Admin.model.AddOnsModel;

public interface AddOnsRepository extends MongoRepository<AddOnsModel,String> {
}
