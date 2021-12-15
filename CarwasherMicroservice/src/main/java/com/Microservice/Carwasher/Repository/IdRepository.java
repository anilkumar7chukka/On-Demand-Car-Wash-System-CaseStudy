package com.Microservice.Carwasher.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Microservice.Carwasher.Model.IdGenerator;


	@Repository
	public interface IdRepository extends MongoRepository<IdGenerator, String>{

	}

