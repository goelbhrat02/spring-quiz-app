package com.quiz.backpro.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.backpro.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{
	public List<Quiz> findByStatus(Boolean b);
}
