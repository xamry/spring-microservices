package com.xamry.microservices.conversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feign client for currency exchange microservice
//Uses OpenFeign to talk to an external microservice
//Keep name same as spring application name for the external microservice
//URL will be used to actually call the microservice
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
	
	//Method similar to the one in Currency exchange service, except that the return type has to be a bean 
	//Available in currency conversion microservice
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	

}
