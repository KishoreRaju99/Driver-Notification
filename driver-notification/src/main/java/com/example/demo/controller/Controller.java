package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.TripService;

@RestController
public class Controller {

	@Autowired
	TripService service;
	@Autowired
	private BookingRepository repo;
	
	
	
     public BookingRepository getRepo() {
		return repo;
	}
     @Autowired
	public void setRepo(BookingRepository repo) {
		this.repo = repo;
	}
	@GetMapping(path="/All")
	public List<BookingRequest> getallplans(){
	
	return this.repo.findAll();
	
	}
       @GetMapping(path="/Getalldetails/{TripId}")                           
       public List<BookingRequest> getbytripid(@PathVariable("TripId") long srchid){
    	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
    	   
		return book.get();
    	   
       }

       @GetMapping(path="/Address/")                           
       public List<BookingRequest> getbytripid1(@RequestParam(value 	= "TripId") long srchid){
           	   Optional<List<BookingRequest>> book=this.service.findByTripCabId(srchid);
           	  
       		return book.get();
           	   
              }



     @PutMapping("/update/{employeeId}")
     public ResponseEntity<BookingRequest> updatebyid(@PathVariable("employeeId")Long id ,@RequestBody BookingRequest entryset){
     Optional<BookingRequest> entity=repo.findById(id);
     System.out.print(entity.get());
     	BookingRequest bookingrequest=null;
     	if(entity.isPresent()) {
 System.out.print("hi");
     		bookingrequest=entity.get();
     			bookingrequest.setStatus(entryset.getStatus());

     		this.repo.save(bookingrequest);
     	}
     		return ResponseEntity.status(HttpStatus.OK).body(bookingrequest);
     		}
    
     
     @PutMapping("/update/for/{TripId}")
     public ResponseEntity<BookingRequest> updatebytripid(@PathVariable("TripId")Long id,@RequestBody List<BookingRequest> entryset){
    	 System.out.println(entryset);
      		 
    	BookingRequest entryset1= service.updatebytripid(id,entryset); 
      	 
    	return ResponseEntity.status(HttpStatus.OK).body(entryset1);
       }
        
@GetMapping(path = "/bookings/status/{TripId}")
public ResponseEntity<List<BookingRequest>> getFilteredBookings(@PathVariable("TripId") long tripId)
{
	//System.out.println(tripId);
	List<BookingRequest> requests = this.service.findShowusers(tripId).get();
	
	return ResponseEntity.status(HttpStatus.OK).body(requests);
}

@PutMapping("/update/for/show/{TripId}")
public ResponseEntity<BookingRequest> updatebytripidforshow(@PathVariable("TripId")Long id ,@RequestBody List<BookingRequest> entryset){
	 System.out.print(entryset);
	
	BookingRequest entryset1= service.updatebytripidforshow(id,entryset); 
 	 
	return ResponseEntity.status(HttpStatus.OK).body(entryset1);
}


@PutMapping("/employee/status/{employeeId}/{tripId}")
public ResponseEntity<BookingRequest> storeEmployeeStatus(@PathVariable("employeeId")int employeeID,@PathVariable("tripId")long tripCabID)
{
	// status = this.service.storeEmployeeStatus(employeeID);
	BookingRequest savedStatus = this.service.storeEmployeeStatus(employeeID);
	
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
}
//For updating the end status of cab
 @PutMapping("/updateme/{tripCabId}")
   public ResponseEntity<TripCabInfo> updatebytripCabID(@PathVariable("tripCabId")long tripCabID){
    	
    		 
    		TripCabInfo savedStatus = this.service.updateTrip(tripCabID); 
    	 
    	 
    	 
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
     }
 
 
 @PutMapping("/updateme/Ongoing/{tripCabId}")
 public ResponseEntity<TripCabInfo> updatebytripCabIDforOngoing(@PathVariable("tripCabId")long tripCabID){
	 System.out.print(tripCabID);
  		 
  		TripCabInfo savedStatus = this.service.updateTripforOngoing(tripCabID); 
  	 
  	 
  	 
	return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
   }

 @GetMapping(path = "/tripdetails/{id}")
	public ResponseEntity<List<TripCabInfo>> getTripDetails(@PathVariable("id")long tripCabID)
	{
		List<TripCabInfo> tripdetails = this.service.getTripDetails(tripCabID);
		
		return ResponseEntity.status(HttpStatus.OK).body(tripdetails);
	}

//For getting server time-startTime
@GetMapping("getServerTime/{tripCabID}")
public TripCabInfo getBookingTime(@PathVariable("tripCabID") long tripCabID)
{
return this.service.getBookingTime(tripCabID);

}




}
