package com.validtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.validtest.ValidTestApplication;

@Configuration
public class BeanConfigs {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				ValidTestApplication.logger.info("INGRESO POR EL FILTRO");
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
