package com.home.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.home.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@SessionScope
@Component
public class CustomerHolder {
	
	private Customer customer;
}