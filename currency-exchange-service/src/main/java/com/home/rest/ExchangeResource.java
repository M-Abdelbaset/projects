package com.home.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.home.model.Exchange;
import com.home.repository.ExchangeRepo;

@RestController
public class ExchangeResource {

	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeRepo exchangeRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeResource.class);

	@GetMapping(path = "/exchange/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Exchange getExchange(@PathVariable String from, @PathVariable String to) {
		
		int port = Integer.parseInt(env.getProperty("local.server.port"));
		
		Exchange ex = exchangeRepo.findByFromAndTo(from, to);
		ex.setPort(port);
		
		LOGGER.info("DB response: {}", ex);
		
		return ex;
	}
}
