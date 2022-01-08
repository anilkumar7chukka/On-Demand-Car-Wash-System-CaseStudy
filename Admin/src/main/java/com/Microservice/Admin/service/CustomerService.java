package com.Microservice.Admin.service;

import com.Microservice.Admin.model.CustomerModel;
import com.Microservice.Admin.model.PromoModel;
import com.Microservice.Admin.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<CustomerModel> findAll(){
        List<CustomerModel> customerList = customerRepository.findAll();
        if(customerList.size()>0){
            return customerList;
        }
        return null;
    }

    public String deleteById(String id){
        if(customerRepository.findById(id).isPresent()){
            customerRepository.deleteById(id);
            return "Successfully Deleted";
        }
        return "Could not any Item";
    }
}
