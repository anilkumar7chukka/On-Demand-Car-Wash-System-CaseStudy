package com.Microservice.AdminPanel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.AdminPanel.model.Admin;
@Repository
public interface AdminPanelRepository extends MongoRepository<Admin,Integer>{

}
