package com.home.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NaturalId;

import com.home.dto.CustomerDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Customer")
@Table(name = "customer")
@AllArgsConstructor @NoArgsConstructor @Getter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	@NaturalId
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	private String authority;
	
	@Version
	private Short version;
	
	public Customer(CustomerDTO customerDTO) {
		this.firstName = customerDTO.getFirstName();
		this.lastName = customerDTO.getLastName();
		this.email = customerDTO.getEmail();
		this.authority = customerDTO.getAuthority();
	}
	
	public Customer firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Customer lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Customer email(String email) {
		this.email = email;
		return this;
	}
	
	public Customer password(String password) {
		this.password = password;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if(!(obj instanceof Customer))
			return false;
		else {
			Customer that = (Customer) obj;
			return Objects.equals(this.getEmail(), that.getEmail());
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getEmail());
	}
}
