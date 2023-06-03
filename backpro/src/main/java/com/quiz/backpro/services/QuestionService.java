package com.quiz.backpro.services;

import java.util.List;
import java.util.Set;

import com.quiz.backpro.entity.Question;
import com.quiz.backpro.entity.Quiz;

public interface QuestionService {
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Question getQuestion(Integer id);
	
	public List<Question> getQuestionsOfQuiz(Integer id);
}
