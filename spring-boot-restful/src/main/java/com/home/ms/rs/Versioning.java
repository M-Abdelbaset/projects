package com.home.ms.rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.home.ms.model.Version1;
import com.home.ms.model.Version2;
import com.home.ms.model.Version2.Name;

@RestController
@RequestMapping(path = "/name")
public class Versioning {
	
	private static final Version1 V1 = new Version1("fname", "lname");
	private static final Version2 V2 = new Version2(new Name("fname", "lname"));
	
	@GetMapping(path= "/v1")
	public Version1 getNameV1() {
		return V1;
	}
	
	@GetMapping(path= "/v2")
	public Version2 getNameV2() {
		return V2;
	}
	//////////////////////////////////
	@GetMapping(params = "v=1")
	public Version1 getNameParamV1() {
		return V1;
	}
	
	@GetMapping(params = "v=2")
	public Version2 getNameParamV2() {
		return V2;
	}
	//////////////////////////////////
	@GetMapping(headers = "v=1")
	public Version1 getNameHeaderV1() {
		return V1;
	}
	
	@GetMapping(headers = "v=2")
	public Version2 getNameHeaderV2() {
		return V2;
	}
	//////////////////////////////////
	@GetMapping(produces = "application/v1+json")
	public Version1 getNameAcceptsV1() {
		return V1;
	}
	
	@GetMapping(produces = "application/v2+json")
	public Version2 getNameAcceptsV2() {
		return V2;
	}
}
