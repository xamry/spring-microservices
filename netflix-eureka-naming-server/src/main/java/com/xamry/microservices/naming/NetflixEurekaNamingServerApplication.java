package com.xamry.microservices.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Enable it as a Eureka server
//When a microservice starts up, it registers with the Naming service. This is called Service Registration.
//Whenever a microservice wants to talk to another microservice, it looks up in the naming service using service name. This is called Service Discovery.

//Each microservice needs to be configured to be able to talk to naming server.
//Also, ribbon needs to be configured to be able to talk to naming server.
@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
	}

}
