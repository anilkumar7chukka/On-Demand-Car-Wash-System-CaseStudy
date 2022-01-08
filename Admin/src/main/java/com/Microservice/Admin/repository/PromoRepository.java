package com.Microservice.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Microservice.Admin.model.PromoModel;

import java.util.Optional;

public interface PromoRepository extends MongoRepository<PromoModel,String> {
    PromoModel findByCode(String code);

}
