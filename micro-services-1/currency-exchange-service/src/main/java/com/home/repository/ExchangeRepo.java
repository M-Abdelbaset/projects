package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.model.Exchange;

public interface ExchangeRepo extends JpaRepository<Exchange, Integer> {
	
	Exchange findByFromAndTo(String from, String to);
}
