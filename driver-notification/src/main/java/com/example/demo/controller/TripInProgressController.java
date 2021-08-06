package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.service.TripInProgressService;

@RestController
@CrossOrigin(origins = "*")
public class TripInProgressController {

	@Autowired
	TripInProgressService serviceforinprogress;

	@GetMapping(path = "/bookings/status/{TripId}")
	public ResponseEntity<List<BookingRequest>> getFilteredBookings(@PathVariable("TripId") long tripId) {

		List<BookingRequest> requests = this.serviceforinprogress.findShowusers(tripId).get();

		return ResponseEntity.status(HttpStatus.OK).body(requests);
	}

	// For storing status of Employee
	@PutMapping(path = "/employee/status/{employeeID}")
	public ResponseEntity<BookingRequest> storeEmployeeStatus(@PathVariable("employeeID") String employeeID) {
		BookingRequest savedStatus = this.serviceforinprogress.storeEmployeeStatus(employeeID);
		return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
	}

	// For updating the end status of cab
	@PutMapping("/updateme/{tripCabId}")
	public ResponseEntity<TripCabInfo> updatebytripCabID(@PathVariable("tripCabId") long tripCabID) {

		TripCabInfo savedStatus = this.serviceforinprogress.updateTrip(tripCabID);

		return ResponseEntity.status(HttpStatus.OK).body(savedStatus);
	}

	// For getting server time-startTime
	@GetMapping(path = "getServerTime/{tripCabID}")
	public TripCabInfo getBookingTime(@PathVariable("tripCabID") long tripCabID) {
		return this.serviceforinprogress.getBookingTime(tripCabID);

	}

}
