package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
 @Setter
@Document(collection = "Bookingrequest")
public class BookingRequest {
	@Id
	public long bookingId ;
	public  int employeeId ;
	public String employeeName;
	public String source;
	public String destination;
	public String dropPoint;
	LocalDateTime bookingTime;
	LocalTime timeSlot;
	int addedManually;
	long tripCabId;
	LocalTime startTime;
	LocalTime reachedTime;
	String complaintDescription;
	String remarks;
	public String status;
	String createdBy;
	LocalDate createdDate;
	String modifiedBy;
	LocalDate modifiedDate;
	int isDeleted;
}
