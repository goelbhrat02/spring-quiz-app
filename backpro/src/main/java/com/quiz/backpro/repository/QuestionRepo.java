package com.quiz.backpro.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.backpro.entity.Question;
import com.quiz.backpro.entity.Quiz;

public interface QuestionRepo extends JpaRepository<Question, Integer>{

	List<Question> findByQuiz(Quiz quiz);

}
