package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.CabInfo;



public interface CabInfoRepo extends MongoRepository<CabInfo, String>{
	
	CabInfo findByCabNumber(String cabNumber);
}
