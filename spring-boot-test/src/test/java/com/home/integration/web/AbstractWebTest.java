package com.home.integration.web;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(classes = {
		RestfulController.class, 
		WebController.class,
		ServiceImpl.class})
public abstract class AbstractWebTest {
}