package com.home.studentsservice.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GRADES-SERVICE")
public interface SimpleGradesServiceFeignProxy {

	@GetMapping(path = "/grade")
	String getGrade();
}
