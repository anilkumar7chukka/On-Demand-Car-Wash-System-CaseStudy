package com.Microservice.Admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class CustomerModel {
    @Id
    private String id;
    private String username;
    
    private String customerPlace;
    private String customerAddress;
    private String customerRating;
    private String customerEmail;
}
