package com.in28minutes.microservices.springsecurityauthentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

	
	@GetMapping("/")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome User";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome Admin";
	}
	
	
}
