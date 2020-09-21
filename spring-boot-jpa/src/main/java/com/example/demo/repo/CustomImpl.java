package com.example.demo.repo;

import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomImpl<T, ID> extends SimpleJpaRepository<T, ID> implements MyNoRepo<T, ID> {

	private final EntityManager entityManager;

	public CustomImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public T getCustom(Class<T> klass, ID id) {
		return entityManager.find(klass, id);
	}
}
