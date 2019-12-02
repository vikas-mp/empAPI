package com.employeeAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages={
		"com.employeeAPI.controller", "com.employeeAPI.dao", "com.employeeAPI.repository", "com.employeeAPI.model","com.employeeAPI","com.employeeAPI.config"})
@EntityScan(basePackages = {"com.employeeAPI.model"}) 
@EnableJpaAuditing
public class EmployeeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
