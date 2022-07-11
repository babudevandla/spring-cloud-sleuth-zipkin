package com.microservice2.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/microservice2")
public class Microservice2Ctrl {

	private final static Logger LOGGER = LoggerFactory.getLogger(Microservice2Ctrl.class);

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public String welcome() {
		LOGGER.info("Inside microservice2 welcome() method and returning response for the requested resource.");
		// Here for simplicity we are directly returning the response from the controller method.
		// Reader can have their own set of implementation like calling the service which in turn
		// interacts with the dB or the calling another microservice.
		return "Hello world from Slueth and Zipkin configuration";
	}
}
