package com.raman.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {
	
	@Autowired
	private Environment env;
	
	// Avoid this if you can: http://localhost:8080/envDetails
	@GetMapping("/envDetails")
	public String envDetails() {
		return env.toString();
	}

}
