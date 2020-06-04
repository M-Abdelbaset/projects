package com.home.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Conversion {

	private Integer id;
	private String from;
	private String to;
	private BigDecimal factor;
	private BigDecimal amount;
	private BigDecimal result;
	private int port;
}
