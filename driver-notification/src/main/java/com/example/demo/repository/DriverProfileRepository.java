package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.DriverProfile;

@Repository
public interface DriverProfileRepository extends MongoRepository<DriverProfile, String> {

	@Query(value="{cabNumber:?0}")
	DriverProfile getDriverProfileByCabNumber(String cabNumber);
	
}