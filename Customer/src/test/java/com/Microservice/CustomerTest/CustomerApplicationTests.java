package com.Microservice.CustomerTest;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.Microservice.Customer.controller.CustomerController;
import com.Microservice.Customer.model.OrderModel;
import com.Microservice.Customer.service.OrderService;


@SpringBootTest
class CustomerApplicationTests {

	@MockBean
	private OrderService orderservice;
	
	@InjectMocks
	private CustomerController contr;
	
	@Autowired
    private MockMvc mockMvc;
 
	

	@Test
	void contextLoads() {
	}

	public List<OrderModel> orders = new ArrayList<>();
	
//	@Test
//	public void getAllOrdersTest() {
//		orders.add(new OrderModel("1", "Anil", "root", "five", "anil@gmail.com", "1", null, null, null, null, 1, 1, 1, "1", "1"));
//		
//		  Mockito.when(orderservice.orderFindAll()).thenReturn(orders);
//	        mockMvc.perform(get("/getMapping")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
//	                .andExpect(jsonPath("$[0].id", Matchers.equals("1")));
//		
//		when(contr.vieworders()).thenReturn(orders);
//		assertEquals(2, contr.vieworders().size());
	}

