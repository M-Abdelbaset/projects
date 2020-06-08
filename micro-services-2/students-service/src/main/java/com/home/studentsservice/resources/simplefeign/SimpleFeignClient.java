package com.home.studentsservice.resources.simplefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="test", url = "http://localhost:8089")
public interface SimpleFeignClient {

	@GetMapping(path = "/mock/feign?idParam={id}")
	String getFeignData(@RequestParam(name = "id") String id);
	
	@PostMapping(path = "/mock/feign")
	String postFeignData(String body);
}
