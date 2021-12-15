package com.Microservice.Consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Microservice.Consumer.model.Car;

public interface CarRepository extends MongoRepository<Car,Integer>{

}
