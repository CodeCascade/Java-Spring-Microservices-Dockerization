package com.in28minutes.microservices.springsecurityjdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

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
