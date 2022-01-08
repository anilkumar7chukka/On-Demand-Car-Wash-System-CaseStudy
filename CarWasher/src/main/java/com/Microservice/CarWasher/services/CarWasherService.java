package com.Microservice.CarWasher.services;

import com.Microservice.CarWasher.VO.Customer;
import com.Microservice.CarWasher.VO.Order;
import com.Microservice.CarWasher.VO.ResponseTemplateVO;
import com.Microservice.CarWasher.model.WasherModel;
import com.Microservice.CarWasher.repository.WasherRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class CarWasherService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WasherRepo washerRepo;


    public Order[] vieworders() {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        ResponseEntity<Order[]> responseEntity = restTemplate.getForEntity("http://CUSTOMER-SERVICE/user/view_orders",Order
                [].class);
        Order[] orders = responseEntity.getBody();

        return orders;
    }
    public String save(WasherModel washerModel){
        washerRepo.save(washerModel);
        return "Added";
    }

    public WasherModel viewWasher(String username){
        return washerRepo.findByUsername(username);
    }

}
