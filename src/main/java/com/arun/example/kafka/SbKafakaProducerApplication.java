package com.arun.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@SpringBootApplication
public class SbKafakaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbKafakaProducerApplication.class, args);
	}
	
	@Bean
	public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter() {
	    return new MappingJackson2XmlHttpMessageConverter(
	        new Jackson2ObjectMapperBuilder()
	            .defaultUseWrapper(false)
	            .createXmlMapper(true)
	            .build()
	    );
	}

}
