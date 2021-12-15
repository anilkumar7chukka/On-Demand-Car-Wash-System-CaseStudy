package com.greenWash.carWasher.TestApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Microservice.Carwasher.Model.CarWasher;
import com.Microservice.Carwasher.Repository.CarWasherRepository;
import com.Microservice.Carwasher.controller.CarWasherController;

@TestConfiguration
@SpringBootTest
public class CarwasherControllerTest {
	@Mock
	private CarWasherRepository carRepo;

	@InjectMocks
	private CarWasherController contr;
	
	public List<CarWasher> carwasher;
	
	@Test 
	public void getAllCarWasherTest() {
		when(contr.getcarwashers()).thenReturn(Stream
				.of(new CarWasher(7,"Anil","anil@gmail.com","Full mech","5Y","Full","Hyd"),
					new CarWasher(8,"Chai","chay@gmail.com","Foam wash","4Y","Interior","Vizag")).collect(Collectors.toList()));
		assertEquals(2,contr.getcarwashers().size());
	}
	
	@Test 
	public void getCarWasherByIdTest(){
		CarWasher carWasher = new CarWasher(2,"dussy","dussy@gmail.com","interior","5Y","Outer","Srikakulam");
		Optional<CarWasher> op = Optional.of(carWasher);
		when(contr.getcarwasherById(2)).thenReturn(op);
		assertEquals(5,op.get().getCarwasherid());
	}

	@Test 
	public void updateCarWasherByidTest(){
		CarWasher carWasher = new CarWasher(7,"Anil","anil@gmail.com","Full mech","5Y","Full","Hyd");
		Optional<CarWasher> optional =Optional.of(carWasher);
		when(contr.update(1, carWasher)).thenReturn(optional);
		assertEquals(5,optional.get().getCarwasherid());
	}
	
//	@Test 
//	public void deleteCarWasherByidTest(){
//		CarWasher carWasher = new CarWasher(5,"g","s","s","s","s","s");
//		Optional<CarWasher> optional =Optional.of(carWasher);
//		when(contr.deleteCarwasher(5)).thenReturn(optional);
//		assertEquals(5,optional.get().getCarwasherid());
//	}
//	
	
	
	
//	@DeleteMapping("/deletecarwasher/{id}")
//	public String deletebook(@PathVariable int id) {
//		carwasherrepository.deleteById(id);
//		return "Order Deleted with id :"+id;	
//	}

//	doThrow(new PersistenceException("Exception occured")).when(mockObject).myMethod(any());
//	@Test 
//	public void TestFindByName(){
//		CarWasher carWasher = new CarWasher(7,"Anil","","","");
//		//carwasher.add(new CarWasher (7,129,"","","",""));
//		Optional<CarWasher> op = Optional.of(carWasher);
//		when(carRepo.findByName("Anil")).thenReturn(op);
//		assertEquals("Anil",carWasher.getCarwashername());
//	}

}
