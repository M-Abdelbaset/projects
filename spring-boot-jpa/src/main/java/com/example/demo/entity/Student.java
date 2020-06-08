package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Student")
@Table(name = "student")
@Setter @Getter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Exam> exams = new HashSet<>();
	
	public void addExam(Exam exam) {
		if (exam != null) {
			exams.add(exam);
			exam.setStudent(this);
		}
	}
	
	public void removeExam(Exam exam) {
		if(exam != null) {
			exams.remove(exam);
			exam.setStudent(null);
		}
	}
}
