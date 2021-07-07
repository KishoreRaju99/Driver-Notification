package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.AdminContacts;
import com.example.demo.entity.DriverProfile;
import com.example.demo.entity.TripAssignedDetails;
import com.example.demo.repository.AdminContactsRepository;
import com.example.demo.repository.DriverNotificationRepository;
import com.example.demo.repository.DriverProfileRepository;

@SpringBootApplication
public class DriverNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverNotificationApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			DriverNotificationRepository driverNotificationRepo;
			
			@Autowired
			DriverProfileRepository  DriverProfileRepos;
			
			@Autowired
			AdminContactsRepository AdminContactsReposs;
			
			@Override
			public void run(String... args) throws Exception {
				
				TripAssignedDetails notification = new TripAssignedDetails("Trip has been assigned to the driver","Alpha City","Shollinganallur",LocalTime.of(20, 30),LocalDate.now(),LocalTime.now(),"AssignedTrip","TN8S6677");
				driverNotificationRepo.save(notification);
//				
//				DriverProfile profile = new DriverProfile("Jawahar","Driver","TN8S6677");
//				DriverProfileRepos.save(profile);
//				
//				AdminContacts contacts1 = new   AdminContacts("+91- 123456789", "Ragahavan");
//				AdminContacts contacts2 = new   AdminContacts("+91-(123)8492003", "santhosh");
//				AdminContactsReposs.save(contacts1);
//				AdminContactsReposs.save(contacts2);
//				
			}
		};
	}
	
}

