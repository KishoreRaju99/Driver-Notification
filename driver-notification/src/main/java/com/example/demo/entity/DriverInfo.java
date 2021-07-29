package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "DriverInfo")
public class DriverInfo {	

	@Id
	long driverId; 
	String driverName;
	String password;
	int driverNumber;
	String licenseNumber;
	LocalDate expiryDate; 
	String createdBy; 
	LocalDate createdDate;
	String modifiedBy;//
	LocalDateTime modifiedDate; 
	int isDeleted; 

}
