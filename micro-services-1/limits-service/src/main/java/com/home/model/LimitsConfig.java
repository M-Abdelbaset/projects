package com.home.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "limits.service")
public class LimitsConfig {

	private Integer min;
	private Integer max;
}
