package com.home.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.home.entity.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class CustomerDTO {

	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Email
	private String email;
	
	private String password;
	
	private String authority = "ROLE_USER";
	
	public CustomerDTO(Customer customer) {
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.email = customer.getEmail();
		
		if(customer.getAuthority() != null && 
				!customer.getAuthority().isBlank())
			this.authority = customer.getAuthority();
	}
	
	public CustomerDTO firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CustomerDTO lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public CustomerDTO email(String email) {
		this.email = email;
		return this;
	}
	
	public CustomerDTO password(String password) {
		this.password = password;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else if(!(obj instanceof CustomerDTO))
			return false;
		else {
			CustomerDTO that = (CustomerDTO) obj;
			return Objects.equals(this.getFirstName(), that.getFirstName()) &&
					Objects.equals(this.getLastName(), that.getLastName()) &&
					Objects.equals(this.getEmail(), that.getEmail()) &&
					Objects.equals(this.getPassword(), that.getPassword());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, password);
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", authority=" + authority + "]";
	}
}
