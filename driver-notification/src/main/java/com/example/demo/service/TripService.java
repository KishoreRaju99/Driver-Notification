package com.example.demo.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.TripCabInfoRepository;


@Service(value="Service")
public class TripService {
	
	@Autowired
    private BookingRepository repo;

	@Autowired
	private TripCabInfoRepository triprepo;
	


public Optional<List<BookingRequest>> findByTripCabId(long srchid){
	return this.repo.findByTripCabId(srchid);
	
}


public List<TripCabInfo> getTripDetails(long tripCabId) {

	return this.triprepo.findTripDetailsByTripCabId(tripCabId);
}



public BookingRequest updatebytripid(long Id,List<BookingRequest> entryset)
{
	
	for(BookingRequest each:entryset) {
		 
		 BookingRequest bookingrequest= repo.findByEmployeeIdAndTripCabId(each.getEmployeeId(),Id).get(); 
		 
		 if(!(bookingrequest.getStatus().equals("Cancelled"))) {
   		 bookingrequest.setStatus("Noshow");
   		 repo.save(bookingrequest);
		 }
		
		 
	 }

	return null;
	

}


public BookingRequest updatebytripidforshow(long Id,List<BookingRequest> entryset)
{
	
	for(BookingRequest each:entryset) {
		
		 BookingRequest bookingrequest= repo.findByEmployeeIdAndTripCabId(each.getEmployeeId(),Id).get(); 
		 
		 if(!(bookingrequest.getStatus().equals("Cancelled"))) {
   		 bookingrequest.setStatus("OnProgress");
   		 
		 }
		  repo.save(bookingrequest);
		 
	 }
	
	
	
	
	return null;
	

}

public TripCabInfo updateTripforOngoing(long tripCabID) {

	Optional<TripCabInfo> save= triprepo.findById(tripCabID);
	TripCabInfo status= save.get();
	status.setStartTime(LocalTime.now());
	status.setStatus("Onprogress");

	
	return triprepo.save(status);
	
}



public TripCabInfo getTripAssignedDetailsByCabNumberaftercancelling(String cabNumber,long tripCabId) {

    Optional<TripCabInfo> save= triprepo.findByCabNumberAndTripCabId(cabNumber,tripCabId);
    TripCabInfo status= save.get();
    status.setStartTime(LocalTime.now());
    status.setStatus("Cancelled");
    
    return triprepo.save(status);
}

public TripCabInfo findTripCabInfo(long srchid) {

	Optional<TripCabInfo> trip = this.triprepo.findById(srchid);
	return trip.get();
}


}