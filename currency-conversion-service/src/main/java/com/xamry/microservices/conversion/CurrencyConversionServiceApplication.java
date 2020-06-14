package com.xamry.microservices.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

//Microservice will register with Eureka Naming service each time it starts
@EnableDiscoveryClient

//Scan package for Feign clients
@EnableFeignClients("com.xamry.microservices.conversion")
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
