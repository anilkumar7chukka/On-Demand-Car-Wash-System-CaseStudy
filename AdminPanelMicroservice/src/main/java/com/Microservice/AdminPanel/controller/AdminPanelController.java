package com.Microservice.AdminPanel.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.Microservice.AdminPanel.model.Admin;
import com.Microservice.AdminPanel.model.Car;
import com.Microservice.AdminPanel.model.CarWasher;
import com.Microservice.AdminPanel.model.Consumer;
import com.Microservice.AdminPanel.model.Order;
import com.Microservice.AdminPanel.repository.AdminPanelRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Admin")
public class AdminPanelController {
	@Autowired
	private AdminPanelRepository adminpanelrepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allorders")
	@HystrixCommand(fallbackMethod="getFallbackOrders")
	public List<Order> getOrders(){
		return  this.restTemplate.getForObject("http://Consumer/Order/allorders", List.class);
	}
//	public List<Order> getFallbackOrders(){
//		return Arrays.asList(new Order(0,0,0,"Not working",0,"Nowhere"));
//	}
	
	@GetMapping("/allcars")
	@HystrixCommand(fallbackMethod="getFallbackCars")
	public List<Car> getCars(){
		return  this.restTemplate.getForObject("http://Consumer/Car/allcars", List.class);
	}
	public List<Car> getFallbackCars(){
		return Arrays.asList(new Car(0L,"No car","No car number","No image","No colour","No owner","Nowhere"));
	}
	
	@GetMapping("/findconsumer/{id}")
	public Consumer getconsumer(@PathVariable int id){
		return this.restTemplate.getForObject("http://Consumer/Consumer/findconsumer/"+id,Consumer.class);
	}
	
	@DeleteMapping("/deleteconsumer/{id}")
	public String deleteconsumer(@PathVariable int id) {
		
		return "Consumer Deleted with id :"+id;	
	}
	
	@GetMapping("/allcarwashers")
	@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getCarwasher(){
		return this.restTemplate.getForObject("http://CarwasherService/carwashers/allcarwashers",List.class);
	}
//	public List<?> getFallbackCarwasher(){
//		return Arrays.asList(new CarWasher(0,"No Carwasher",0,"No experience","00000000000"));
//	}
	
	@GetMapping("/allconsumers")
	@HystrixCommand(fallbackMethod="getFallbackConsumers")
	public List<?> getConsumers(){
		return  this.restTemplate.getForObject("http://Consumer/Consumer/allconsumers", List.class);
	}
	public List<?> getFallbackConsumers(){
		return Arrays.asList(new Consumer(0,"No Consumer","0","No E-mail","Nowhere"));
	}
	
	
	@PostMapping("/admin")
	public String addadmin(@RequestBody Admin admin) {
		adminpanelrepository.save(admin);
		return "Admin  with Id: "+admin.getAdminid()+" has been processed";
	
	}
	
	@GetMapping("/alladmins")
	public List<Admin>getadmins(){
		return adminpanelrepository.findAll();
	}
	
	@GetMapping("/findadmin/{id}")
	public Optional<Admin>getord(@PathVariable int id){
		return adminpanelrepository.findById(id);
	}
}
