package com.home.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseConstrainImpl implements ConstraintValidator<CourseConstrain, String> {
	
	private String targetValue;
	
	@Override
	public void initialize(CourseConstrain constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		targetValue = constraintAnnotation.value();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		boolean result;
		
		if(value != null)
			result = value.startsWith(targetValue);
		else
			result = true; // not mandatory
		
		return result;
	}
	
}
