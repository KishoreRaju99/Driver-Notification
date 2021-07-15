package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
//import com.example.demo.entity.TripAssignedDetails;
import com.example.demo.entity.TripCabInfo;


@Repository
public interface DriverNotificationRepository extends MongoRepository<TripCabInfo, String> {

		@Query(value="{cabNumber:?0,status:{$nin:[CompletedTrip]}}")
		TripCabInfo getTripAssignedDetailsByCabNumber(String cabNumber);
		
}