package com.xamry.microservices.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//Microservice will register with Eureka Naming service each time it starts
@EnableDiscoveryClient

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
	//Create bean for "Always Sampler" to be used by Sleuth 
	public Sampler defaultSampler() {
		//Samples (intercepts) all requests for distributed tracing by Sleuth
		return Sampler.ALWAYS_SAMPLE;
	}

}
