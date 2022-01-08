package com.Microservice.Customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoModel {
    @Id
    private String id;
    private String code;
    private double price;
    private String description;
    private boolean active;
}
