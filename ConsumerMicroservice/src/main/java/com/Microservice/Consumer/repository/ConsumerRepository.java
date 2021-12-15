package com.Microservice.Consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.Consumer.model.Consumer;
@Repository
public interface ConsumerRepository extends MongoRepository<Consumer,Integer>{

}
