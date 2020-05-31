package com.home.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Limits;
import com.home.model.LimitsConfig;

@RestController
@RequestMapping(path = "/limits")
public class LimitsResource {

	@Autowired
	private LimitsConfig limits;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Limits getLimits() {
		return new Limits(limits.getMin(), limits.getMax());
	}
}
