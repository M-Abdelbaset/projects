package com.home.ms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.home.ms.model.User;

@Repository
public interface JPAUserRepository extends JpaRepository<User, Integer> {

}
