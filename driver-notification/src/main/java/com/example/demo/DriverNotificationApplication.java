package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.CabInfo;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.BookingRepository;
import com.example.demo.repo.CabInfoRepo;
import com.example.demo.repo.DriverInfoRepo;
import com.example.demo.repo.EmployeeDetailsRepository;
import com.example.demo.repo.TripCabInfoRepository;

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
	 private EmployeeDetailsRepository EmployeeReposs;
	 
	 @Autowired
	 private CabInfoRepo repos;
	 
	 @Autowired
	 private  DriverInfoRepo driverRepo;
	
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			
			@Override
			public void run(String... args) throws Exception {
				
				
				CabInfo cabInfo=new CabInfo("TN50S6677", 101, "Swift", 10, "LC12D90",null , "Jawahar", null, null, null, null, 0);
				
				repos.save(cabInfo);			
				
				DriverInfo driverInfo = new DriverInfo(101, "Jawahar", "1234567890", 0, null, null, null, null, null, null, 0);
				
				driverRepo.save(driverInfo);
				
				
				EmployeeDetails contacts1 = new EmployeeDetails("1001","Ragahavan",null,9123456780l,1,0,null,null,null,null,null,null,null,null,0); 	
				EmployeeDetails contacts2 = new EmployeeDetails("1002", "santhosh",null,9123849200l,1,0,null,null,null,null,null,null,null,null,0);
				
				EmployeeReposs.save(contacts1); 
				EmployeeReposs.save(contacts2);

				
				
				TripCabInfo tripdetails = new TripCabInfo(10014,"TN50S6677","Swift",104,"Bayline","Tambaram",LocalDate.now() ,
						                                   LocalTime.now(),10,2,8,"Assigned",null,null,null,null,null,null,0);
				
				triprepo.save(tripdetails);
			
				
				
				BookingRequest book2=new BookingRequest(1001449,"10723","vignesh","alphacity","shollinganallur","velachery",
						                                LocalTime.now(),LocalTime.now(),0,10014,null,null,null,null,"Assigned",null,null,null,null,0);
				
				repo.save(book2);
		
			}
		};
	}
	
	
	}