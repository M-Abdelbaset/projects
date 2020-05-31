package com.home.around;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ServiceDao {

	public List<String> run(boolean thro) {
		
		if(thro) {
			throw new RuntimeException();
		} else {
			return new ArrayList<String>(List.of("one", "two"));
		}
	}
}
