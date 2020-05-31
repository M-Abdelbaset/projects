package com.test.key.composite;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Employee")
@Table(name = "employee")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Employee {
	
	@EmbeddedId
	private EmployeeId employeeId;
	
	@NaturalId
	private String name;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Phone> phones = new HashSet<>();
	
	public Employee(Company company, String name) {
		EmployeeId employeeId = new EmployeeId(company, 1);
		this.employeeId = employeeId;
		this.name = name;
	}
	
	public void addPhone(Phone phone) {
		this.phones.add(phone);
		phone.setEmployee(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee))
			return false;
		else {
			Employee that = (Employee) obj;
			return Objects.equals(that.getEmployeeId(), this.employeeId);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
}