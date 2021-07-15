package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Document(collection="TripCabInfo")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripCabInfo {

	@Id
	long tripCabId;
    String cabNumber;
    int driverID;
    String source;
    String destination;
    String dropPoint;

 

    LocalDate dateOfTravel;
    LocalDateTime timeSlot;
    int totalSeats;
    int remainingSeats;
    int allocatedSeats;
    LocalTime startTime;
    LocalTime endTime;

 

    String status;
    String createdBy;
    LocalDate createdDate;
    String modifiedBy;
    LocalDate modifiedDate;
    int isDeleted;
	
}
