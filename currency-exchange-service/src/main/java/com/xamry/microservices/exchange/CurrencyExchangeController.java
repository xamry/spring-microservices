package com.xamry.microservices.exchange;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	//Instance of Logger to log the request
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//Environment to retrieve port of the instance where this microservice is running
	//We can run the microservice on a different port by using VM argument -Dserver.port for example.
	@Autowired
	private Environment environment;
	
	//Repository to perform JPA queries
	@Autowired
	private ExchangeValueRepository repository;
	
	//http://localhost:8000/currency-exchange/from/USD/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		logger.info("CurrencyExchangeService :: Exchange Value -> {}", exchangeValue);
		
		return exchangeValue;
	}
}
