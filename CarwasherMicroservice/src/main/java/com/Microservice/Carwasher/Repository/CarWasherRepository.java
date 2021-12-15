package com.Microservice.Carwasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.Carwasher.Model.CarWasher;
@Repository
public interface CarWasherRepository extends MongoRepository<CarWasher, Integer> {


}
