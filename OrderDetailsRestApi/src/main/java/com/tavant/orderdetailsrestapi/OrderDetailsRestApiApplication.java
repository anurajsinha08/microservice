package com.tavant.orderdetailsrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderDetailsRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsRestApiApplication.class, args);
	}

}
