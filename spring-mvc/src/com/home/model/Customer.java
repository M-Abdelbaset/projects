package com.home.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.home.validation.CourseConstrain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
	
	private String firstName;
	
	@NotEmpty(message = "Not empty")
	@Size(min = 2, message = "At least 2 characters")
	private String lastName;
	
	@NotNull(message = "must not be null")
	private Integer count;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "must be 5 chars/digits")
	private String postalCode;
	
	@CourseConstrain(value = "JAV", message = "Must be Java")
	private String course;
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", count=" + count + ", postalCode="
				+ postalCode + ", course=" + course + "]";
	}
}
