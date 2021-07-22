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
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDetails {

	@Id
    String employeeId;
	String employeeName;
	String employeMail;
	long phoneNumber;//
	int isAdmin; //
	int isBlocked; //
	LocalDateTime blockedDate; //
	String domain;
	String domainLead;
	String projectName;
	String createdBy;
	LocalDate createdDate;
	String modifieBy;
	LocalDateTime modifiedDate;//
	int isDeleted; //
	
	
	
}
