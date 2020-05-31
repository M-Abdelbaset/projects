package com.home.rest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.home.model.Conversion;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
@FeignClient(name = "zuul-api-gateway")
//@RibbonClient(name = "currency-exchange-service")
public interface ExchangeProxy {

	//@GetMapping(path = "/exchange/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/currency-exchange-service/exchange/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Conversion getExchange(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
