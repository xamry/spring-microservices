package com.xamry.springboot.restful.springbootrestfulws.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//Message source for i18n
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello Xamrians!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Xamrians!");
	}
	
	@GetMapping(path = "/hello-world/path/{name}")
	public HelloWorldBean helloWorldParhVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	
	/*
	 * @GetMapping(path = "/hello-world-i18n") public String
	 * helloWorldI18N(@RequestHeader(name = "Accept-Language", required = false)
	 * Locale locale) { return messageSource.getMessage("good.morning.message",
	 * null, locale); }
	 */
	
	@GetMapping(path = "/hello-world-i18n")
	public String helloWorldI18N() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
