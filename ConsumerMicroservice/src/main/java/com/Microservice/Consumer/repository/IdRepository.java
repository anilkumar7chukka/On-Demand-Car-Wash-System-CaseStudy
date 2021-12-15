package com.Microservice.Consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.Consumer.model.IdGenerator;




	@Repository
	public interface IdRepository extends MongoRepository<IdGenerator, String>{

	}

