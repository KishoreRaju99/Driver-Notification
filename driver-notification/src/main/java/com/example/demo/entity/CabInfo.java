package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "CabInfo")

public class CabInfo {	
	
	@Id
	String  cabNumber;
	long driverId;
	String  cabModel;
	int availableSeats;
	String insuranceNumber;
	Date insuranceExpiryDate; 
	String  driverName;
	String createdBy;
	LocalDate createdDate; 
	String modifiedBy;
	LocalDateTime modifiedDate; 
	int isDeleted;
	
	
}
