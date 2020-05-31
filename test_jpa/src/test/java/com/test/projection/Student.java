package com.test.projection;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Student")
@Table(name = "student")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@CreationTimestamp
	private Date createdAt;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
