package com.example.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CabInfo;
import com.example.demo.entity.UserRequest;
import com.example.demo.loginbl.LoginBl;
import com.example.demo.repo.CabInfoRepository;

@CrossOrigin(origins = { "*" })
@RestController
public class LoginController {

	@Autowired
	private LoginBl loginBl;

	@Autowired
	private CabInfoRepository cabInfoRepo;

	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody UserRequest userRequest) throws Exception {
		try {
			// controller->bl->Dl->Repo->Db
			return ResponseEntity.ok(loginBl.validateUser(userRequest));
		} catch (BadCredentialsException | UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad Credential");

		}

	}

	@GetMapping("/CabInfo/{cabNumber}")
	public ResponseEntity<CabInfo> cabInfo(@PathVariable("cabNumber") String cabNumber) {
		Optional<CabInfo> cab = this.cabInfoRepo.findById(cabNumber);
		CabInfo cabInfo = cab.get();

		return ResponseEntity.status(HttpStatus.OK).body(cabInfo);

	}
}