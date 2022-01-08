package com.Microservice.Customer.controller;


import com.Microservice.Customer.model.*;
import com.Microservice.Customer.repository.OrderRepository;
import com.Microservice.Customer.service.CustomerService;
import com.Microservice.Customer.service.OrderService;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class CustomerController {
        @Autowired
        private  CustomerService customerService;

        @Autowired
        private OrderService orderService;

        @GetMapping("/")
        public ResponseEntity<?>home(){
            return new ResponseEntity<>("Hello",HttpStatus.OK);
        }

        @PostMapping("/new_customer")
        public ResponseEntity<?> addCustomer(@RequestBody CustomerModel customer){
            try{
                customerService.save(customer);
                return new ResponseEntity<>("Added", HttpStatus.OK);
            }catch (Exception e){
                //add Logger method
                 return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
            }
        }
    @PostMapping("/new_order")
    public ResponseEntity<?> addNewOrder(@RequestBody OrderModel customer){
        try{
            orderService.save(customer);
            return new ResponseEntity<>("Added", HttpStatus.OK);
        }catch (Exception e){
            //add Logger method
            return  new ResponseEntity<>("Order could not be placed : ",HttpStatus.BAD_REQUEST);
        }
    }
        @GetMapping("/view_orders")
        public ResponseEntity<?> viewAllOrders(){
            List<OrderModel> listOfOrders = orderService.orderFindAll();
            if(listOfOrders!=null){
                return new ResponseEntity<>(listOfOrders,HttpStatus.OK);
            }
            return new ResponseEntity<>("No Orders Found",HttpStatus.NOT_FOUND);
        }

        @GetMapping("/view_customer/{id}")
        public CustomerModel viewCustomer(@PathVariable("id") String username){
            return customerService.findCustomer(username);
        }
        @GetMapping("/view_orders/{id}")
        public List<?> viewCustomerOrder(@PathVariable("id") String username){
            List<OrderModel> listOfOrders = orderService.customerOrderFindAll(username);
            return listOfOrders;
        }
        @GetMapping("/view_addons")
        public List<AddOnsModel> viewAddons(){
            return orderService.addOnsFindAll();
        }

        @GetMapping("/view_promos")
        public List<PromoModel> viewPromos(){
            return orderService.promosFindAll();
        }

        @GetMapping("/view_cardetails")
        public List<CarDetailsModel> carDetails(){
            return orderService.carDetails();
        }

        @DeleteMapping("/delete_order/{id}")
        public ResponseEntity<?> deletePromo(@PathVariable("id") String id){
            return new  ResponseEntity<>(orderService.deleteById(id),HttpStatus.OK);
        }

}
