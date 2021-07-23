package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.DriverNotificationRepository;
import com.example.demo.repo.EmployeeDetailsRepository;
import com.example.demo.service.TripService;


@RestController
public class DriverNotificationController {

	@Autowired
	private TripService service;
	@Autowired
	private DriverNotificationRepository repofordrivernotification;

	@Autowired
	private EmployeeDetailsRepository employeeRepo; 

	@Autowired
	private CabInfoRepo cabInfoRepo;

	// FOR DRIVER'S NOTIFICATION

	@GetMapping(path = "/notification/{cabNumber}")
	public TripCabInfo getNotificationByCabNumber(@PathVariable String cabNumber) {
		TripCabInfo tripObj = this.repofordrivernotification.getTripAssignedDetailsByCabNumber(cabNumber);
		return tripObj;
	}

	// FOR DRIVER PROFILES

	@GetMapping(path = "/driverProfile/{cabNumber}")
	public CabInfo getProfileByCabNumber(@PathVariable String cabNumber) {
		CabInfo driverprofile = this.cabInfoRepo.findByCabNumber(cabNumber);
		return driverprofile;
	}

	// FOR ADMIN CONTACT DETAILS

	@GetMapping(path = "/adminContactDetails")
	public List<EmployeeDetails> getAdminContacts() {
		List<EmployeeDetails> admincontact = this.service.findByIsAdmin();
		
		return admincontact;

	}

}
