package com.xamry.microservices.conversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Feign client for currency exchange microservice
//Uses OpenFeign to talk to an external microservice
//Keep name same as spring application name for the external microservice
//URL will be used to actually call the microservice

//No need to specify URL in FeignClient annotation when using it as Ribbon Client, it will be configured in application.properties as a listOfServers
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")

//Use this when connecting directly to external microservice
//@FeignClient(name = "currency-exchange-service")

//Use this when connecting to external microservice via Zuul API gateway
@FeignClient(name = "netflix-zuul-api-gateway-server")

//To be able to call multiple instances of external microservice using Netflix Ribbon client side load balancing
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//Method similar to the one in Currency exchange service, except that the return type has to be a bean 
	//Available in currency conversion microservice
	
	//Use this GetMapping when connecting directly to external microservice
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	//Use this GetMapping when connecting to external microservice via Zuul API gateway. Notice service name at the start of URL
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	

}
 	