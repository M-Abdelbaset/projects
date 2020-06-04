package com.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // a generic annotation to eanble any service discovery in the classpath(eireka, consul, zookeeper)
// @EnableEurekaClient is specific to eureka only. Both are optional in recent versions(if your classpath contains eureka client, it's enabled by default)
public class LimitsService {
	
	public static void main(String[] args) {
		SpringApplication.run(LimitsService.class, args);	
	}
}
