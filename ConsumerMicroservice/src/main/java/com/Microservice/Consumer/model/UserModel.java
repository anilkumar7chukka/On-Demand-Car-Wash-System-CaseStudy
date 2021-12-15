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
@Document(collection="users")
public class UserModel {
	
	@Id
	private String id;
	
	private String username;
	
	private String password;
	
	
}
