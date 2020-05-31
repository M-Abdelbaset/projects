package com.home.beanconfig2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class TestInterfaceBeans {
	
	@Autowired(required = false)
	private Child2 child2;
	
	@Autowired
	private Parent child22;

//	@Autowired(required = false) // defining it here, it will be injected!
//	private Child2 child2;

}
