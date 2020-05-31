package com.test.key.composite;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Phone")
@Table(name = "phone")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Phone {
	
	@Id
	private String number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "foreign_id", referencedColumnName = "company_id"),
		@JoinColumn(name = "foreign_num", referencedColumnName = "employee_num")
	})
	private Employee employee;
	
	public Phone(String number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Phone))
			return false;
		else {
			Phone that = (Phone) obj;
			return Objects.equals(that.getNumber(), this.number);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}