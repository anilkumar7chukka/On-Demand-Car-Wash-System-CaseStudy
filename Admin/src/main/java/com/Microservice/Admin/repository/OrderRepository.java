package com.Microservice.Admin.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.Microservice.Admin.model.OrderModel;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderModel,String> {

    List<OrderModel> findByCustomerName (String username);

}
