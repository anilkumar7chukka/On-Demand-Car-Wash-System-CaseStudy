package com.Microservice.Customer.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class CustomerModel {
    @Id
    private String id;
    private String username;
    private String password;
    private String customerPlace;
    private String customerAddress;
    private String customerRating;
    private String customerEmail;
}
