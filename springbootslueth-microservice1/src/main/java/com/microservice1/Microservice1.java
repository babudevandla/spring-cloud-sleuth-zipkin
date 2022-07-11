package com.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class Microservice1 {

	private final static Logger LOGGER = LoggerFactory.getLogger(Microservice1.class);

	public static void main(String[] args) {
		SpringApplication.run(Microservice1.class, args);
		LOGGER.info("Springboot slueth zipkin microservice1 started successfully.");
	}

	// Configuring the restTemplate object.
	// Ideally should be in the Configuration class. We are omitting the extra classes for the simplicity of this tutorial.
	// We have omitted the use of FeignClient for this tutorial. But readers can go ahead and explore that area.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Introducting sampling as in distributed tracing logging is very high
	// There are two types of sampler - ALWAYS_SAMPLE or NEVER_SAMPLER.
	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
