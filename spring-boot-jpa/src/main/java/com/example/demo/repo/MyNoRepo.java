package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyNoRepo<T, ID> extends Repository<T, ID> {

	List<T> findAll();
	
	T getCustom(Class<T> klass, ID id);
}
