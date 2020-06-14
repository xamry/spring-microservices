package com.xamry.microservices.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication

//Microservice will register with Eureka Naming service each time it starts
@EnableDiscoveryClient

//Scan package for Feign clients
@EnableFeignClients("com.xamry.microservices.conversion")
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}
	
	@Bean
	//Create bean for "Always Sampler" to be used by Sleuth 
	public Sampler defaultSampler() {
		//Samples (intercepts) all requests for distributed tracing by Sleuth
		return Sampler.ALWAYS_SAMPLE;
	}

}
