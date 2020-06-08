package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Exam;
import com.example.demo.repo.ExamRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		ExamRepository examRepository = context.getBean(ExamRepository.class);
		examRepository.findByName("new name");
	}
	
}


// transaction behavior of repos?