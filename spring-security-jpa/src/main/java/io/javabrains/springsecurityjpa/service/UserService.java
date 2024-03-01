package io.javabrains.springsecurityjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.javabrains.springsecurityjpa.entity.UserInfo;
import io.javabrains.springsecurityjpa.repository.UserInfoRepository;

@Service
public class UserService {

	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	 public String addUser(UserInfo userInfo) {
		 System.out.println("aaaa");
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        repository.save(userInfo);
	        return "user added to system ";
	    }
	
}
