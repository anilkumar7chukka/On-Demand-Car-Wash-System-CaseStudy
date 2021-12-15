package com.Microservice.AdminPanel.model;

import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "OrderDetails")
public class Order {
	private int id;
	private Integer custID;
	private Integer carID;
	private String workStatus;
	private String washType;
	private Date orderDate;
	private Date completionDate;
	private String washLocation;
	
	
	
}