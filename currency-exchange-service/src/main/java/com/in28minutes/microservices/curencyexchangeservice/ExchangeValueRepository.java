package com.in28minutes.microservices.curencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	//Query for finding based on From & To field in database table 
	ExchangeValue findByFromAndTo(String from , String to);
		
	
}
