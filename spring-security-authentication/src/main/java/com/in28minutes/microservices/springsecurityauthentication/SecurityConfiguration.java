package com.in28minutes.microservices.springsecurityauthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfiguration {
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("adminpassword")
                .roles("ADMIN")
                .build();
            
        return new InMemoryUserDetailsManager(user,admin);
    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
//			.securityMatcher("/api/**")                            
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/user").hasAnyRole("USER" , "ADMIN")       
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/").permitAll()
				.anyRequest().authenticated()                      
			)
			.formLogin();
		return http.build();
	}
}
