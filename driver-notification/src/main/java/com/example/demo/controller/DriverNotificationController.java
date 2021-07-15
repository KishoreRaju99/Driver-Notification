package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminContacts;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repository.AdminContactsRepository;
import com.example.demo.repository.CabInfoRepo;
import com.example.demo.repository.DriverNotificationRepository;



@RestController
public class DriverNotificationController {

	@Autowired
	private DriverNotificationRepository repofordrivernotification;
	
	@Autowired
	private AdminContactsRepository reposs;
	
	@Autowired
	private CabInfoRepo cabInfoRepo;
	
	
	 //FOR DRIVER'S NOTIFICATION
	@GetMapping(path="/notification")
	public List<TripCabInfo> getNotification() {
		 return this.repofordrivernotification.findAll();
	}

	@GetMapping(path="/notification/{cabNumber}")
	public TripCabInfo getNotificationByCabNumber(@PathVariable String cabNumber) {
		TripCabInfo tripObj = this.repofordrivernotification.getTripAssignedDetailsByCabNumber(cabNumber);
		return tripObj;
	}



	//FOR DRIVER PROFILES

	@GetMapping(path="/driverProfile")
	public List<CabInfo> getDriverProfile() {
		 return this.cabInfoRepo.findAll();
	}


	@GetMapping(path="/driverProfile/{cabNumber}")
	public CabInfo getProfileByCabNumber(@PathVariable String cabNumber) {
		 return this.cabInfoRepo.findByCabNumber(cabNumber);
	}

	//FOR ADMIN CONTACT DETAILS

	@GetMapping(path="/adminContactDetails")
	public List<AdminContacts> getAdminContacts(){
		return this.reposs.findAll();
		
	}

	
}
