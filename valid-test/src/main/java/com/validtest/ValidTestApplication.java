package com.validtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidTestApplication {
	
	public static Logger logger = LoggerFactory.getLogger(ValidTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ValidTestApplication.class, args);
	}

}
