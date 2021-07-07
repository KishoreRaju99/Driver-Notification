package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminContacts;
import com.example.demo.entity.DriverProfile;
import com.example.demo.entity.TripAssignedDetails;
import com.example.demo.repository.AdminContactsRepository;
import com.example.demo.repository.DriverNotificationRepository;
import com.example.demo.repository.DriverProfileRepository;
@RestController
@RequestMapping(path="/api/v1")
public class TripAssignedController {
     @Autowired
    private DriverNotificationRepository repo;
     
     @Autowired
     private DriverProfileRepository repos;
     
     @Autowired
     private AdminContactsRepository reposs;
     
     //FOR DRIVER'S NOTIFICATION
     
     @GetMapping(path="/notification")
     public List<TripAssignedDetails> getNotification() {
    	 return this .repo.findAll();
     }
@GetMapping(path="/notification/{cabNumber}")
public TripAssignedDetails getNotificationByCabNumber(@PathVariable String cabNumber) {
	return this.repo.getTripAssignedDetailsByCabNumber(cabNumber);
}


// FOR DRIVER PROFILES

@GetMapping(path="/driverProfile")
public List<DriverProfile> getDriverProfile() {
	 return this .repos.findAll();
}


@GetMapping(path="/driverProfile/{cabNumber}")
public DriverProfile getProfileByCabNumber(@PathVariable String cabNumber) {
	return this.repos.getDriverProfileByCabNumber(cabNumber);
}

 	

//FOR ADMIN CONTACT DETAILS

@GetMapping(path="/adminContactDetails")
public List<AdminContacts> getAdminContacts(){
	return this.reposs.findAll();
	
}

}
