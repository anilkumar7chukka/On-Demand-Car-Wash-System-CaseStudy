package com.Microservice.Customer.service;

import com.Microservice.Customer.model.*;
import com.Microservice.Customer.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddOnRepository addOnRepository;
    @Autowired
    private PromoRepository promoRepository;
    @Autowired
    private CarDetailsRepository carDetailsRepository;


    public String save(OrderModel order) {
        orderRepository.save(order);
        return "Successfully Added";
    }

    public List<OrderModel> orderFindAll() {
        List<OrderModel> orderList = orderRepository.findAll();
        if(orderList.size()>0){
            return orderList;
        }
        return null;
    }
    public List<AddOnsModel> addOnsFindAll() {
        List<AddOnsModel> addOnsModelList = addOnRepository.findAll();
        if(addOnsModelList.size()>0){
            return addOnsModelList;
        }
        return null;
    }

    public List<PromoModel> promosFindAll() {
        List<PromoModel> promoModelList = promoRepository.findAll();
        if(promoModelList.size()>0){
            return promoModelList;
        }
        return null;
    }
    public List<CarDetailsModel> carDetails() {
        List<CarDetailsModel> carDetails = carDetailsRepository.findAll();
        if(carDetails.size()>0){
            return carDetails;
        }
        return null;
    }
    public String deleteById(String id){
        orderRepository.deleteById(id);
        return "Successfully Deleted";
    }

    public CustomerModel customerDetails(String username){
        return customerRepository.findByUsername(username);
    }

    public List<OrderModel> customerOrderFindAll(String username) {
        List<OrderModel> customerOrders =  orderRepository.findByCustomerName(username);
        return customerOrders;
    }

}
