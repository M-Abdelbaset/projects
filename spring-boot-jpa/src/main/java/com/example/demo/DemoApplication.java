package com.example.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.demo.entity.Student;
import com.example.demo.repo.CustomImpl;
import com.example.demo.repo.CustomStudentRepository;
import com.example.demo.repo.MyNoRepo;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomImpl.class)
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		
		Set<String> strs = new HashSet<String>();
		strs.add("1");
		strs.add("2");
		strs.add("3");
		
		strs.forEach((val) -> System.out.println(val));
		
		strs = new LinkedHashSet<String>();
		strs.add("1");
		strs.add("2");
		strs.add("3");
		
		strs.forEach((val) -> System.out.println(val));
		
		
		CustomStudentRepository customStudentRepository = context.getBean(CustomStudentRepository.class);
		
		MyNoRepo<Student, Integer> repo = context.getBean(MyNoRepo.class);
		Student custom = repo.getCustom(Student.class, 1);
		System.out.println("done: " + custom);
	}
	
}