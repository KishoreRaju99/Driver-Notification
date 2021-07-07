package com.example.demo.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="AdminContacts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminContacts {

	String contactNumber;
	String adminName;
	
}
