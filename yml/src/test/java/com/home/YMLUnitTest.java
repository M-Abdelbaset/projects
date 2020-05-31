package com.home;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = YMLProps.class)
@TestPropertySource("classpath:application.yml")
public class YMLUnitTest {

	@Autowired
	private YMLProps ymlProps;
	
	@Test
	public void testYmlProps() {
		
		System.out.println(ymlProps);		
	}
}
