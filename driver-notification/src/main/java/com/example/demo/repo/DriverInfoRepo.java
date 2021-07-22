package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.DriverInfo;



@Repository
public interface DriverInfoRepo extends MongoRepository<DriverInfo, Integer>{
	

	DriverInfo findByDriverId(long driverId);
	
}
