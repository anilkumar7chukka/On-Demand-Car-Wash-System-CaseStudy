package com.Microservice.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Admin.model.WasherModel;

public interface WasherRepository extends MongoRepository<WasherModel,String> {

}
