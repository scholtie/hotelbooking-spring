package com.cubicfox.hotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class HotelbookingApplication {

	private static final Logger logger = LoggerFactory.getLogger(HotelbookingApplication.class);

	public static void main(String[] args) {
		logger.info("Init the application...");
		SpringApplication.run(HotelbookingApplication.class, args);
	}

}
