package com.home.qualifiers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
public class Service {

	@Autowired
	@Qualifier("c1")
	private Parent p1;
	
	@Autowired
	@Qualifier("c22")
	private Parent p2;
	

	// autowire beans with same qualifier as the property
//	@Autowired
//	private Parent c22;
	
	@Autowired
	private Parent child3;
	
	////////
	
	@Autowired
	@Qualifier("child-group")
	private List<Parent> childGroup;
	
	///////////////
	
	@Resource(name = "child2")
	private Object child2;
}









