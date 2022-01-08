package com.Microservice.Admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnsModel {
    @Id
    private String id;
    private String addon;
    private double cost;
    private boolean active;
}
