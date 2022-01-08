package com.Microservice.Customer.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Customer.model.AddOnsModel;


public interface AddOnRepository extends MongoRepository<AddOnsModel,String> {
}
