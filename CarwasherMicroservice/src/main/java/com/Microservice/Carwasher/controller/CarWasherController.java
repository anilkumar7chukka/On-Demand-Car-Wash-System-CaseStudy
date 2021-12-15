package com.Microservice.Carwasher.controller;


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
import org.springframework.web.client.RestTemplate;

import com.Microservice.Carwasher.Model.CarWasher;
import com.Microservice.Carwasher.Model.IdGenerator;
import com.Microservice.Carwasher.Repository.CarWasherRepository;
import com.Microservice.Carwasher.Repository.IdRepository;



@RestController
@RequestMapping("/Carwasher")
public class CarWasherController {

	@Autowired
	CarWasherRepository carwasherrepository;
	
	@Autowired
	IdRepository idRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/post")
	public void addCarWasher(@RequestBody CarWasher carWash) {
		IdGenerator idGen= idRepo.findById("carWashId").get();
		carWash.setCarwasherid(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		carwasherrepository.save(carWash);
	}
	
	
	@GetMapping("/allorders")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getOrders(){
		return  this.restTemplate.getForObject("http://CustomerMicroservice/Ord/allorders", List.class);
	}
	//public List<?> getFallbackCarwasher(){
	//	return Arrays.asList(new CarWasher(0,"No",0,00000000,"No service"));
	@GetMapping("/allcars")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getCars(){
		return  this.restTemplate.getForObject("http://CustomerMicroservice/Car/allcars", List.class);
	}
	@PostMapping("/addcarwasher")
	public String addcarwasher(@RequestBody CarWasher carwasher) {
		carwasherrepository.save(carwasher);
		return "CarWahser  with Id: "+carwasher.getCarwasherid()+" has been added";
	}
	
	@PutMapping(value="/carwasher/{id}")
	public Optional<CarWasher> update(@PathVariable("id") int id, @RequestBody CarWasher carwasher) {
	  carwasherrepository.save(carwasher);
	  return carwasherrepository.findById(id);
	}
	
	@GetMapping("/allcarwashers")
	public List<CarWasher> getcarwashers(){
		return carwasherrepository.findAll();
	}
	
	@DeleteMapping("/deletecarwasher/{id}")
	public void deleteCarwasher(@PathVariable int id) {
		carwasherrepository.deleteById(id);
//		return "Order Deleted with id :"+id;	
	}
	
	@GetMapping("/findord/{id}")
	public Optional<CarWasher> getcarwasherById(@PathVariable int id){
		return carwasherrepository.findById(id);
	}
}