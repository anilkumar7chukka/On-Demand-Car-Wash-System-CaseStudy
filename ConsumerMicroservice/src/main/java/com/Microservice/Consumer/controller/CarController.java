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

import com.Microservice.Consumer.model.Car;
import com.Microservice.Consumer.repository.CarRepository;

@RestController
@RequestMapping("/Car")
public class CarController {

	@Autowired
	private CarRepository carrepository;
	@PostMapping("/car")
	public String addcar(@RequestBody Car car) {
		carrepository.save(car);
		return "Car  with Id: "+car.getId()+" has been processed";
	}
	
	@PutMapping(value="/car/{id}")
	public void update(@PathVariable("id") int id, @RequestBody Car car) {
		carrepository.save(car);
	}
	
	@GetMapping("/allcars")
	public List<Car>getcars(){
		return carrepository.findAll();
	}
	
	@DeleteMapping("/deletecar/{id}")
	public String deletecar(@PathVariable int id) {
		carrepository.deleteById(id);
		return "Car Deleted with id :"+id;	
	}
	
	@GetMapping("/findcar/{id}")
	public Optional<Car>getcar(@PathVariable int id){
		return carrepository.findById(id);
	}
}
