package com.Microservice.Consumer.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.Consumer.model.Order;
import com.Microservice.Consumer.repository.OrderRepository;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderRepository orderrepository;
	@PostMapping("/addorder")
	public String addorder(@RequestBody Order order) {
		orderrepository.save(order);
		return "order  with Id: "+order.getId()+" has been processed";
	}
	
	@PutMapping(value="/order/{id}")
	public void update(@PathVariable("id") int id, @RequestBody Order order) {
		orderrepository.save(order);
	}
	
	@GetMapping("/allorders")
	public List<Order>getords(){
		return orderrepository.findAll();
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public String deletecar(@PathVariable int id) {
		orderrepository.deleteById(id);
		return "order Deleted with id :"+id;	
	}
	
	@GetMapping("/findorder/{id}")
	public Optional<Order>getord(@PathVariable int id){
		return orderrepository.findById(id);
	}
}
