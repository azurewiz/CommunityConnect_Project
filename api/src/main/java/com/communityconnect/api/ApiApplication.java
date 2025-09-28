package com.communityconnect.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // <-- ADD THIS IMPORT
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories; // <-- ADD THIS IMPORT

// Tell Spring Boot where to find each type of repository
@EnableJpaRepositories(basePackages = "com.communityconnect.api.repository") // <-- ADD THIS ANNOTATION
@EnableMongoRepositories(basePackages = "com.communityconnect.api.repository") // <-- ADD THIS ANNOTATION
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}