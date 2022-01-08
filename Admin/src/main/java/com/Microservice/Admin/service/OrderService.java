package com.Microservice.Admin.service;


import com.Microservice.Admin.model.OrderModel;
import com.Microservice.Admin.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> orderFindAll() {
        List<OrderModel> orderList = orderRepository.findAll();
        if(orderList.size()>0){
            return orderList;
        }
        return null;
    }
    public String deleteById(String id){
        orderRepository.deleteById(id);
        return "Successfully Deleted";
    }


}
