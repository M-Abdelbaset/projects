package com.home.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseConstrainImpl.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseConstrain {
	
	public String value() default "LUV";
	public String message() default "Invalid course code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
