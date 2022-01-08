package com.Microservice.CarWasher.VO;

import com.Microservice.CarWasher.model.WasherModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Customer customer;
    private Order order;
    private WasherModel washerModel;
}
