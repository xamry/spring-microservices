package com.xamry.microservices.conversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	//**************Calling external microservice using RestTemplate***************
	@GetMapping(path = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		//Parameters to be passed to Exchange Service URI
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		//Using RestTemplate to call other REST resource and get the entity auto populated
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean bean = response.getBody();		
		
		return new CurrencyConversionBean(bean.getId(), from, to, bean.getConversionMultiple(), 
				quantity,
				quantity.multiply(bean.getConversionMultiple()), bean.getPort());
	}
	
	// **************Calling external microservice using Feign Proxy ***************
	//Feign
	// 1. Simplifies the code calling other microservices
	// 2. Provides integration with ribbon client side load balancing
	@GetMapping(path = "/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyViaFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean bean = proxy.retrieveExchangeValue(from, to);
		
		
		return new CurrencyConversionBean(bean.getId(), from, to, bean.getConversionMultiple(), 
				quantity,
				quantity.multiply(bean.getConversionMultiple()), bean.getPort());
		
	}
}
