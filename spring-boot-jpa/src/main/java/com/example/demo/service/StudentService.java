package com.example.demo.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired private StudentRepository studentRepository;
	
	@Transactional
	public void saveStudent(Student std) {
		studentRepository.save(std);
	}
	
	@Transactional
	public void saveAll(Set<Student> students) {
		studentRepository.saveAll(students);
	}
}
