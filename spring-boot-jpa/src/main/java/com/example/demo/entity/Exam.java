package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Exam")
@Table(name = "exam")
@Setter @Getter
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
}
