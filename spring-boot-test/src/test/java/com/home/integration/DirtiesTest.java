package com.home.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import lombok.Getter;
import lombok.Setter;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SingletonBean.class)
@TestMethodOrder(OrderAnnotation.class)
public class DirtiesTest {

	@Autowired
	private SingletonBean bean;
	
	@Test
	@Order(1)
	void changeState() {
		bean.setState(100);
	}
	
	@Test
	@Order(2)
	void affectedByState() {
		assertEquals(100, bean.getState());
	}
	
	@Test
	@Order(3)
	@DirtiesContext
	void resetState() {}
	
	@Test
	@Order(4)
	void retestState() {
		assertEquals(1, bean.getState());
	}
}

@Component
@Scope("singleton")
@Getter @Setter
class SingletonBean {
	private int state = 1;
}