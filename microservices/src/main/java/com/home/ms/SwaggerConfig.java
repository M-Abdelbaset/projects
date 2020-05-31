package com.home.ms;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket gocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		ApiInfo info = new ApiInfo("Api title", 
				"Api desription", 
				"1.0", 
				"urn:tos",
				new Contact("Mohamed", "mohamed.com", "mohamed@gmail"), 
				"Apache 2.0", 
				"http://www.apache.org/licenses/LICENSE-2.0", 
				new ArrayList<VendorExtension>());
		
		return info;
	}
}
