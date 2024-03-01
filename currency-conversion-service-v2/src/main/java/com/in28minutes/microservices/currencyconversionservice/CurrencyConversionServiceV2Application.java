package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceV2Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceV2Application.class, args);
	}

}
