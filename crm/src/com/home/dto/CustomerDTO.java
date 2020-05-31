package com.home.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.home.entity.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
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
}
