package com.microservice1.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/microservice1")
public class Microservice1Ctrl {

	private final static Logger LOGGER = LoggerFactory.getLogger(Microservice1Ctrl.class);

	@Autowired
	RestTemplate restTemplate;

	// Resource URL - http://localhost:10091/microservice1
	@GetMapping
	public String welcome() {
		LOGGER.info("Inside microservice1 welcome() method.");

		// Hitting the microservice2 from microservice1 to fetch the response.
		// For simplicity we are directly configuring the url earlier.
		// For production ready applications it should be populated from the AWS param store or the properties file.
		final String microservice2Url = "http://localhost:10092/microservice2";
		final String response = (String) restTemplate.exchange(microservice2Url, HttpMethod.GET, null, String.class).getBody();

		LOGGER.info("The response received from microservice2= " + response);
		// Returning the response to the user.
		return response;
	}
}
