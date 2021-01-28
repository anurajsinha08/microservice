package com.tavant.employeerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
	}

}
