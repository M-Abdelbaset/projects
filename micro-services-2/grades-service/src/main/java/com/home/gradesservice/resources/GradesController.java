package com.home.gradesservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradesController {

	@Autowired Environment env;
	@Autowired GradesIntegratorWithHystrix gradesIntegrator;

	@GetMapping(path="/grade")
	String gradeById() {
		System.out.println(gradesIntegrator.getClass());
		return String.valueOf(env.getProperty("server.port")) + " " + gradesIntegrator.extract();
	}
}
