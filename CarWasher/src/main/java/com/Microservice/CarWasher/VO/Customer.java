package com.Microservice.CarWasher.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customerName;
    private String customerPlace;
    private String customerAddress;
    private String customerRating;
    private String customerEmail;
}
