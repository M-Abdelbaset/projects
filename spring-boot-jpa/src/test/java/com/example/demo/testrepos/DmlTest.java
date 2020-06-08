package com.example.demo.testrepos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.demo.AbstractApplicationTest;
import com.example.demo.entity.Student;

class DmlTest extends AbstractApplicationTest {
	
	@Test
	void persist() {
		// setup
		Student student = new Student();
		student.setName("new student");

		// run
		student = studentRepository.save(student);
		//studentRepository.flush();
		
		// assert
		Assertions.assertNotNull(student.getId());
	}
}
