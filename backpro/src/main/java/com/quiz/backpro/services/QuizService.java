package com.quiz.backpro.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.quiz.backpro.entity.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public List<Quiz> getQuizzes();
	
	public List<Quiz> getActiveQuizzes();
	
	public Quiz getQuiz(Integer qid);
	
	public void updateQuizStatus(LocalDateTime currentDateTime);
}
