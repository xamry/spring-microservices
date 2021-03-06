package com.xamry.springboot.restful.springbootrestfulws;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringbootRestfulWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWsApplication.class, args);
	}
	
	//Locale Resolver for I18N
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	//Resource Bundle Message Source for i18n
	//Not needed if you put spring.messages.basename entry in application.properties
	//Not working somehow, so uncommented
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		
		return messageSource;
	}	

}
