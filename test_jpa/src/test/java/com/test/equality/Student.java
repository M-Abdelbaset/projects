package com.test.equality;

import java.util.Objects;

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

@Entity(name = "Student")
@Table(name = "student")
@Setter @Getter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if(!(obj instanceof Student))
			return false;
		else {
			Student that = (Student) obj;
			return Objects.equals(this.company, that.company);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.company);
	}
}
