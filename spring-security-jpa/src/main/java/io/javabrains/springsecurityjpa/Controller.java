package io.javabrains.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springsecurityjpa.dto.AuthRequest;
import io.javabrains.springsecurityjpa.entity.UserInfo;
import io.javabrains.springsecurityjpa.service.JwtService;
import io.javabrains.springsecurityjpa.service.UserService;

@RestController
@RequestMapping
public class Controller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String home() {
		System.out.println("aaa");
		return "Welcome";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String user() {
		return "Welcome User";
	}
	
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String admin() {
		return "Welcome Admin";
	}
	
	@PostMapping("/newuser")
	public String addUser(@RequestBody UserInfo userinfo) {
		System.out.println(userinfo);
		return userService.addUser(userinfo);
	}
	
	@PostMapping("/authenticate")
	public String autheticateAndGetToken(@RequestBody AuthRequest authRequest){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("Invalid User Request!");
		}
		
	}
	
	
}
