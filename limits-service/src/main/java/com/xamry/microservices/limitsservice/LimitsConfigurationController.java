package com.xamry.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	//Reads properties from config file (either application.properties or config server, whichever is the case)	
	@GetMapping(path = "/limits")
	public LimitConfiguration retrieveLimitConfiguration() {
		return new LimitConfiguration(configuration.getMinimum(),  configuration.getMaximum());
	}
}
