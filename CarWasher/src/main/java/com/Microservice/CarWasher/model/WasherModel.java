package com.Microservice.CarWasher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("washer")
public class WasherModel {

        @Id
        private int id;
        private String username;
        private String password;
        private String washerRating;
        private String washerEmail;

}
