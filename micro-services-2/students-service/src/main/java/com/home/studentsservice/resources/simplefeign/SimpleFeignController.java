package com.home.studentsservice.resources.simplefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleFeignController {

	@Autowired private SimpleFeignClient simpleFeignClient;
	
	@GetMapping(path = "/feign/{id}")
	public String testFegin(String id) {
		return simpleFeignClient.getFeignData(id);
	}
	
	@GetMapping(path = "/feign/post")
	public String postFegin(String id) {
		return simpleFeignClient.postFeignData("hello world!");
	}
}
