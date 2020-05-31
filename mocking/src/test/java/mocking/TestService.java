package mocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class TestService {

	@Injectable
	private Service service;
	
	@Test
	public void test1() {
		System.out.println(service);
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
