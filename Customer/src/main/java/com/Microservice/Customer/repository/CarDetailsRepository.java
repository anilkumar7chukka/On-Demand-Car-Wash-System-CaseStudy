package com.Microservice.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Customer.model.CarDetailsModel;

public interface CarDetailsRepository extends MongoRepository<CarDetailsModel,String> {
}
