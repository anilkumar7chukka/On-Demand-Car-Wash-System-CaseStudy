package com.Microservice.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Customer.model.CustomerModel;




public interface CustomerRepository extends MongoRepository<CustomerModel,String> {
    CustomerModel findByUsername(String username);


}
