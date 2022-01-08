package com.Microservice.CarWasher.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    private String customerName;
    private String customerEmail;
    private String washerName;
    private String washerEmail;
    private String promoCode;
    private double washcost;
    private double promoprice;
    private double addOnCost;
    private String date;
    private String time;
}
