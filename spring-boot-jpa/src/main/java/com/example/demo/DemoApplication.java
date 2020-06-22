package com.example.demo;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		StudentService stdService = context.getBean(StudentService.class);
		
		stdService.saveAll(Set.of(
				new Student(2, "number 2", null), 
				new Student(2, "number 23", null)) // duplicate id
		);
		
	}
	
}


// transaction behavior of repos?