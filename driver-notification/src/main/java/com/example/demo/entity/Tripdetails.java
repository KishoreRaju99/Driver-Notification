package com.example.demo.entity;


import org.springframework.data.annotation.Id;

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

public class Tripdetails {
	
	@Id
	public int tripId ;
	Detailsonly details;
	Detailsonly details2;
	Detailsonly details3;
	
	
	
	
	
	
	
	
	

}
