package com.Microservice.AdminPanel.model;

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
@Document(collection="ConsumerData")
public class Consumer {
	
	@Id
	private int consumerid;
	private String consumername;
	private String consumermobile;
	private String consumeremail;
	private String consumerlocation;
	
	

	
}
