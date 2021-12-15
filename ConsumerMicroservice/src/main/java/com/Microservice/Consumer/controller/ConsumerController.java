package com.Microservice.Consumer.controller;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Microservice.Consumer.model.CarWasher;
import com.Microservice.Consumer.model.Consumer;
import com.Microservice.Consumer.repository.ConsumerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/Consumer")
public class ConsumerController {
	@Autowired
	private ConsumerRepository consumerrepository;
	
	@Autowired
	private  RestTemplate restTemplate;
	
	@GetMapping("/allcarwashers")
	@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getCarwasher(){
		return this.restTemplate.getForObject("http://Carwasher/Carwashers/allcarwashers",List.class);
	}
	public List<?> getFallbackCarwasher(){
		return Arrays.asList(new CarWasher(0,"No name","No email","No services","No experience","No Washtypes","Nowhere"));
	}
	@PostMapping("/addconsumer")
	public String addconsumer(@RequestBody Consumer consumer) {
		consumerrepository.save(consumer);
		return "Consumer  with Id: "+consumer.getConsumerid()+" has been added";
	}
	
	@RequestMapping(value="/consumer/{id}", method=RequestMethod.PUT)
	public void updateconsumer(@PathVariable("id") int id, @RequestBody Consumer consumer) {
		consumerrepository.save(consumer);
	}
	
	@GetMapping("/allconsumers")
	public List<Consumer> getconsumer(){
		return consumerrepository.findAll();
	}
	
	@DeleteMapping("/deleteconsumer/{id}")
	public String deleteconsumer(@PathVariable int id) {
		consumerrepository.deleteById(id);
		return "Consumer Deleted with id :"+id;	
	}
	
	@GetMapping("/findconsumer/{id}")
	public Consumer getconsumer(@PathVariable int id){
		return consumerrepository.findById(id).get();
	}
}
