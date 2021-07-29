package com.example.demo.dl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CabInfo;
import com.example.demo.repo.CabInfoRepository;


@Component
public class LoginDl {

	@Autowired
	private CabInfoRepository cabInfoRepo;
	
	public CabInfo findByCabNumber(String cabNumber) {
		return this.cabInfoRepo.findByCabNumber(cabNumber);
	}
	
}