package com.example.demo.entity;

import java.time.LocalDate;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "CabInfo")
@Setter
@Getter
public class CabInfo {
	
	
	
	@Id
	String  cabNumber;
	
	long driverId;
	String  cabModel;
	int availableSeats;
	String insuranceNumber;
	Date expiryDate;
	String  driverName;
	int isDeleted;
	String createdBy;
	String modifiedBy;
	LocalDate createdDate;
	LocalDate modifiedDate;
	
	
}
