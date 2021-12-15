package com.Microservice.Consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Microservice.Consumer.model.Order;

public interface OrderRepository extends MongoRepository<Order,Integer>{

}
