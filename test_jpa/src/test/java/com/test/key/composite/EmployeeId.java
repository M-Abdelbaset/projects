package com.test.key.composite;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeId implements Serializable{

	private static final long serialVersionUID = 1L;
//	@Column(name = "company_id")
//	private Integer companyId;
	
	@ManyToOne
	@MapsId("companyId")
//	@JoinColumn(name = "company_id", insertable = false, updatable = false) // equivalent to @MapsId
	private Company company;
	
	@Column(name = "employee_num")
	private Integer employeeNumber;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EmployeeId))
			return false;
		else {
			EmployeeId that = (EmployeeId) obj;
			return Objects.equals(that.getCompany(), this.company) 
					&& Objects.equals(that.getEmployeeNumber(), this.employeeNumber);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(company, employeeNumber);
	}
}
