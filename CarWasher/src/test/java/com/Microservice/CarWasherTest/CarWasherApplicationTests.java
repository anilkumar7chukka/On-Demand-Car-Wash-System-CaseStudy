package com.Microservice.CarWasherTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import com.Microservice.CarWasher.Controller.CarWasherController;
import com.Microservice.CarWasher.VO.Order;
import com.Microservice.CarWasher.model.WasherModel;
import com.Microservice.CarWasher.services.CarWasherService;

@SpringBootConfiguration
@TestConfiguration
@ContextConfiguration
@SpringBootTest
class CarWasherApplicationTests {

	@Mock
	private CarWasherService carwasherservice;

	@InjectMocks
	private CarWasherController contr;

	@Test
	void contextLoads() {
	}

	public List<Order> orders = new ArrayList<>();

//	@Test
//	public void getAllOrdersTest() {
//		orders.add(new Order("1", "Anil", "root", "five", "anil@gmail.com", "1", 1, 1, 1, "1", "1"));
//		orders.add(new Order("2", "Chaithu", "root", "five", "chaithu@gmail.com", "1", 1, 1, 1, "1", "1"));
//		
//		when(contr.vieworders()).thenReturn(orders);
//		assertEquals(2, contr.vieworders().size());
//	}
	
	@Test 
	public void getCarWasherByIdTest(){
		WasherModel carWasher = new WasherModel(5,"dussi","dussi@gmail.com","interior","5Y");
		when(contr.viewProfile("dussi")).thenReturn(carWasher);
		assertEquals(5,contr.viewProfile("dussi").getId());
	}
	

}
