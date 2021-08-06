package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.service.DriverNotificationService;

@RestController
@CrossOrigin(origins = "*")
public class DriverNotificationController {

	@Autowired
	private DriverNotificationService notificationservice;

	// FOR DRIVER'S NOTIFICATION

	@GetMapping(path = "/notification/{cabNumber}")
	public TripCabInfo getNotificationByCabNumber(@PathVariable String cabNumber) {
		TripCabInfo tripObj = this.notificationservice.getTripAssignedDetailsByCabNumber(cabNumber);
		return tripObj;
	}

	// FOR DRIVER PROFILES

	@GetMapping(path = "/driverProfile/{cabNumber}")
	public CabInfo getProfileByCabNumber(@PathVariable String cabNumber) {
		CabInfo driverprofile = this.notificationservice.findByCabNumber(cabNumber);
		return driverprofile;
	}

	// FOR ADMIN CONTACT DETAILS

	@GetMapping(path = "/adminContactDetails")
	public List<EmployeeDetails> getAdminContacts() {
		List<EmployeeDetails> admincontact = this.notificationservice.findByIsAdmin();
		return admincontact;

	}

}
