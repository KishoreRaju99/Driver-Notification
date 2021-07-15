package com.example.demo.service;

import java.time.LocalTime;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.TripCabInfoRepository;



@Service(value="Service")
public class TripService {
	@Autowired
private BookingRepository repo;

	@Autowired
	private TripCabInfoRepository triprepo;


public Optional<List<BookingRequest>> findByTripCabId(long srchid){
	return this.repo.findByTripCabId(srchid);
	
}

public Optional<List<BookingRequest>> findShowusers(long srchid){
	return this.repo.findShowUsers(srchid);
	
}


public BookingRequest storeEmployeeStatus(int employeeID) {
	BookingRequest status= repo.findByEmployeeId(employeeID);
	if (status!= null) {
		status.setStatus("Reached");
		status.setReachedTime(LocalTime.now());
	repo.save(status);
	}
	return status;
	

}



//For updating the end status of cab
public TripCabInfo updateTrip(long tripCabId) {
	Optional<TripCabInfo> save= triprepo.findById(tripCabId);
	TripCabInfo status= save.get();
	status.setEndTime(LocalTime.now());
	status.setStatus("Completed");

	
	return triprepo.save(status);
}



public List<TripCabInfo> getTripDetails(long tripCabId) {

	return this.triprepo.findTripDetailsByTripCabId(tripCabId);
}



public BookingRequest updatebytripid(long Id,List<BookingRequest> entryset)
{
	
	for(BookingRequest each:entryset) {
		 //BookingRequest bookingrequest= repo.findByEmployeeId(each.getEmployeeId()).get();
		 BookingRequest bookingrequest= repo.findByEmployeeIdAndTripCabId(each.getEmployeeId(),Id).get(); 
		 
		 if(!(bookingrequest.getStatus().equals("Cancelled"))) {
   		 bookingrequest.setStatus("No-Show");
   		 repo.save(bookingrequest);
		 }
		
		 
	 }
	//return repo.save(bookingrequest);
	
	
	
	return null;
	

}




public BookingRequest updatebytripidforshow(long Id,List<BookingRequest> entryset)
{
	
	for(BookingRequest each:entryset) {
		 //BookingRequest bookingrequest= repo.findByEmployeeId(each.getEmployeeId()).get();
		 BookingRequest bookingrequest= repo.findByEmployeeIdAndTripCabId(each.getEmployeeId(),Id).get(); 
		 
		 if(!(bookingrequest.getStatus().equals("Cancelled"))) {
   		 bookingrequest.setStatus("OnProgress");
   		 //repo.save(bookingrequest);
		 }
		  repo.save(bookingrequest);
		 
	 }
	//return repo.save(bookingrequest);
	
	
	
	return null;
	

}

public TripCabInfo updateTripforOngoing(long tripCabID) {
	Optional<TripCabInfo> save= triprepo.findById(tripCabID);
	TripCabInfo status= save.get();
	status.setStartTime(LocalTime.now());
	status.setStatus("Onprogress");	
	return triprepo.save(status);
	
}

//For getting server time-startTime
public TripCabInfo getBookingTime(long tripCabID) {
//TODO Auto-generated method stub
Optional<TripCabInfo> save= triprepo.findById(tripCabID);
return save.get();
}



}