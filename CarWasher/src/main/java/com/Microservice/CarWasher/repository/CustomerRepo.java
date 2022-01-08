package com.Microservice.CarWasher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.CarWasher.VO.Customer;


public interface CustomerRepo extends MongoRepository<Customer,Long> {

}
