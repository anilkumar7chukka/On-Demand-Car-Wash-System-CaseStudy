package com.Microservice.Customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Customer.model.PromoModel;

public interface PromoRepository extends MongoRepository<PromoModel,String> {
}
