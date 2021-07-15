package com.example.demo;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.CabInfo;
import com.example.demo.repository.AdminContactsRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CabInfoRepo;
import com.example.demo.repository.TripCabInfoRepository;

@SpringBootApplication
public class DriverNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverNotificationApplication.class, args);
	}
	
	 @Autowired
	 private BookingRepository repo; 
	 @Autowired
	 private TripCabInfoRepository triprepo;
	 @Autowired
	 private AdminContactsRepository AdminContactsReposs;
	 
	 @Autowired
	 private CabInfoRepo repos;
	 
	
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			
			@Override
			public void run(String... args) throws Exception {
				
				
				CabInfo cabInfo=new CabInfo("TN50S6677", 101, "Swift", 10, "LC12D90",null , "Jawahar", 0, null, null, null, null);
				repos.save(cabInfo);			
				
				/*
				 * AdminContacts contacts1 = new AdminContacts("+91- 123456789",
				 * "Ragahavan",true); AdminContacts contacts2 = new
				 * AdminContacts("+91-(123)8492003", "santhosh",true);
				 * AdminContactsReposs.save(contacts1); AdminContactsReposs.save(contacts2);
				 * 
				 * 
				 * BookingRequest book2=new
				 * BookingRequest(10022,10722,"gokul","alphacity","shollinganallur","velachery",
				 * LocalDateTime.now(),LocalTime.now(),0,10002,null,null,null,null,"assigned",
				 * null,null,null,null,0); TripCabInfo tripdetails = new TripCabInfo(10001,
				 * "TN8S6677", 10, "Bayline", "Tambaram", "Shollingnallur", LocalDate.now(),
				 * LocalTime.now(), 10,2,8,LocalTime.of(10, 30), null, null, null, null, null,
				 * null, 0); triprepo.save(tripdetails); repo.save(book2);
				 * 
				 * DriverProfile profile = new DriverProfile("Jawahar","Driver","TN8S6677");
				 * DriverProfileRepos.save(profile);
				 */


			}
		};
	}
	
	
	}


