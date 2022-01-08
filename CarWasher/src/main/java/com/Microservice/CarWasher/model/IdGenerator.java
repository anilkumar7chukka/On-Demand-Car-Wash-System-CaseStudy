package com.Microservice.CarWasher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="carwashId")
public class IdGenerator {
    @Id
    String id;
    int seq;
}
