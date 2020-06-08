package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

	List<Exam> findByName(String name);
}
