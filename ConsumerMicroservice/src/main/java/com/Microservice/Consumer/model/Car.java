package com.Microservice.Consumer.model;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "CarDetails")
public class Car {
	public long id;
	public String carName;
	public String carNumber;
	public String carImage;
	public String carColor;
	public String ownerName;
	public String carLocation;
}