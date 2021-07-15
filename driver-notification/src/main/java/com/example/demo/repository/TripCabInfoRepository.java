package com.example.demo.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.TripCabInfo;





public interface TripCabInfoRepository extends MongoRepository<TripCabInfo, Long> {


	List<TripCabInfo> findTripDetailsByTripCabId(long tripCabId);
}
