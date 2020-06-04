package com.home.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.home.model.Conversion;

@RestController
public class ConversionResource {

	@Autowired
	private ExchangeProxy exchangeProxy;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConversionResource.class);
	
	@GetMapping(path = "/calculate/{from}/{to}/{amount}", produces = APPLICATION_JSON_VALUE)
	public Conversion getExchange(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal amount) {

		Map<String, String> vars = new HashMap<String, String>();
		vars.put("from", from);
		vars.put("to", to);
		
		Conversion conversion = new RestTemplate()
				.getForEntity("http://localhost:8000/exchange/{from}/{to}", 
						Conversion.class,
						vars)
				.getBody();
		
		conversion.setAmount(amount);
		conversion.setResult(amount.multiply(conversion.getFactor()));
		
		return conversion;
	}
	
	@GetMapping(path = "/calculate-feign/{from}/{to}/{amount}", produces = APPLICATION_JSON_VALUE)
	public Conversion getExchangeUsingFeign(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal amount) {

		Conversion conversion = exchangeProxy.getExchange(from, to);
		
		LOGGER.info("Exchange response: {}", conversion);
		
		conversion.setAmount(amount);
		conversion.setResult(amount.multiply(conversion.getFactor()));
		
		return conversion;
	}
}
