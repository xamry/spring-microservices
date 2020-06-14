package com.xamry.microservices.apigateway;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

//Meant to add log each request that comes via Zuul API Gateway server
@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	//Instance of Logger to log the request
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		//Should this filter be executed or not. You can make it conditional based on certain logic
		return true;	//This filter will run with every request, since it is always true
	}

	@Override
	public Object run() throws ZuulException {
		//Log details of the request
		
		//Current HTTP Request
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("Request -> {}, request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";	//When should the filter be executed. pre=Before request is executed. post=after request is executed. error= If an error occurs. 
	}

	@Override
	public int filterOrder() {
		//Priority order in case there are multiple filters
		return 1;
	}

}
