package com.xamry.microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

/**
 * API gateway
--------------
All calls get routed through (or intercepted by) API gateway to provide these common services:

Authentication, authorization and security
Rate limits
Fault tolerance
Service aggregation


- API gateways are also great for debugging and doing analytics

Steps:
1. Setup zuul server (by enabling ZuulProxy)
2. Decide what should it do when it intercepts a request (by writing ZuulFilter implementation for example)
3. Pass all requests through it (By using URL: http://localhost:{Zuul Port}/{application.name}/{uri of rest resource}
 
 */


//Make it a Zuul API Gateway
@EnableZuulProxy

//Register with naving server
@EnableDiscoveryClient

@SpringBootApplication
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	//Create bean for "Always Sampler" to be used by Sleuth 
	public Sampler defaultSampler() {
		//Samples (intercepts) all requests for distributed tracing by Sleuth
		return Sampler.ALWAYS_SAMPLE;
	}

}
