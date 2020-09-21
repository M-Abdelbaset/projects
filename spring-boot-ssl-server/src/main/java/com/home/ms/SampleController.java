package com.home.ms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/ssl")
	public String ssl() {
		return "ssl";
	}
}
