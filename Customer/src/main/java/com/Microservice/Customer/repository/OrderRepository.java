package com.Microservice.Customer.repository;

import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Microservice.Customer.model.CustomerModel;
import com.Microservice.Customer.model.OrderModel;

import java.util.List;

public interface OrderRepository extends MongoRepository<OrderModel,String> {

    List<OrderModel> findByCustomerName (String username);

}
