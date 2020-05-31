package com.home.ms.rs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping(path = "/rest")
@Validated
public class RestResource {

	
	@GetMapping
	public String validate(@NotNull String name) {
		return "";
	}
	
	@Getter @Setter
	public static class Bean {
		private String name;
	}
}
