package com.Microservice.Customer.service;

import com.Microservice.Customer.model.CustomerModel;
import com.Microservice.Customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void save(CustomerModel customerModel){
        customerRepository.save(customerModel);
    }

    public CustomerModel findCustomer(String username){
        return customerRepository.findByUsername(username);
    }

    public List<CustomerModel> findAll(){
        List<CustomerModel> customerList = customerRepository.findAll();
        if(customerList.size()>0){
            return customerList;
        }
        return null;
    }
    public String deleteById(String id){
        customerRepository.deleteById(id);
        return "Successfully Deleted";
    }


}
