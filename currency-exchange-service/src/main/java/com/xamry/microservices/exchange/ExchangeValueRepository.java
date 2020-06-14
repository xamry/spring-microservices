package com.xamry.microservices.exchange;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	//Custom Query method
	//Implementation automatically provided by Spring data JPA
	ExchangeValue findByFromAndTo(String from, String to);
}
