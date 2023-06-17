package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
//@EntityScan("com.example.demo")

public class LibraryManagementSystemApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		// Start the scheduler
		

	}

}
