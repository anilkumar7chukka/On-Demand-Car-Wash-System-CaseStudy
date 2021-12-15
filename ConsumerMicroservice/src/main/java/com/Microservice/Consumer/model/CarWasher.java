package com.Microservice.Consumer.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="CarWasherData")
public class CarWasher {
	

	@Id
	private int carwasherid;
	private String carwashername;
	private String email;
	private String carwasherservices;
	private String experience;
	private String washType;
	private String washlocation;
	
	
}
	