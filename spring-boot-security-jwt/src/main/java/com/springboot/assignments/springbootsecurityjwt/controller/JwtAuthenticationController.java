package com.springboot.assignments.springbootsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assignments.springbootsecurityjwt.model.JwtRequest;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/authenticate")
	public String createAuthenticationToken(@RequestBody JwtRequest  authenticationRequest) throws Exception{

authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		return "";
	}
}
