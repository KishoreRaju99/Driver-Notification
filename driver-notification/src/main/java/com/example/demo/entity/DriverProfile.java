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
@Document(collection="DriverProfiles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverProfile {

	String DriverName;
	String role;
	String cabNumber;
}
