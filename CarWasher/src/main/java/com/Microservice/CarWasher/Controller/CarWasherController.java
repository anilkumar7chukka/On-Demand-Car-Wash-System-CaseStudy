package com.Microservice.CarWasher.Controller;

import com.Microservice.CarWasher.VO.Customer;
import com.Microservice.CarWasher.VO.Order;
import com.Microservice.CarWasher.VO.ResponseTemplateVO;
import com.Microservice.CarWasher.model.WasherModel;
import com.Microservice.CarWasher.repository.WasherRepo;
import com.Microservice.CarWasher.services.CarWasherService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/carwasher")

public class CarWasherController {
    @Autowired
    private CarWasherService carWasherService;
    @GetMapping("/")
    public String home(){
        return "hello";
    }
    @GetMapping("/view_orders")
    public List<Order> vieworders(){
        return List.of(carWasherService.vieworders());
    }
    @GetMapping("/profile/{id}")
    public WasherModel viewProfile(@PathVariable("id") String username){
        return carWasherService.viewWasher(username);
    }
    @PostMapping("/order/{id}")
    public ResponseEntity<?> AcceptOrRejectOrder(@PathVariable("id" )Long id){
        return  null;
    }
    @PostMapping("/new_washer")
    public ResponseEntity<?> newWasher(@RequestBody WasherModel washerModel){
        try{
            carWasherService.save(washerModel);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method               
            return  new ResponseEntity<>("Washer could not be Added : ",HttpStatus.BAD_REQUEST);
        }
    }
}
