package com.alpha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@EnableWebMvc
@Configuration
@ComponentScan("com.alpha")
public class WebConfig {
	
	@Bean// use to create an object 
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix("/.jsp");
		
		return resolver;
	}
	
	// viewResolver :- View state doesn't change during the running of the application,so implementations are free to cache views. 

}
