package io.javabrains.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.javabrains.springsecurityjpa.UserInfoToUserDetails;
import io.javabrains.springsecurityjpa.entity.UserInfo;
import io.javabrains.springsecurityjpa.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo =  repository.findByName(username);
		
		return userInfo.map(UserInfoToUserDetails::new)
		.orElseThrow(() -> new UsernameNotFoundException("user not found" +username));
	}

}
