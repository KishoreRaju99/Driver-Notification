package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="TripDetails")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripAssignedDetails {

	String description;
	String source;
	String destination;
	LocalTime timeSlot;
	LocalDate dateOfTravel;
	LocalTime generatedtime;
	String status;
	String cabNumber;
	
}
