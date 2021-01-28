package com.tavant.orderrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderRestApiApplication.class, args);
	}

}
