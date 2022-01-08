package com.Microservice.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Admin.model.CarDetailsModel;

public interface CarDetailsReposistory extends MongoRepository<CarDetailsModel,String> {
}
