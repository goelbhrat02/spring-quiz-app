package com.quiz.backpro.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.backpro.entity.Question;
import com.quiz.backpro.entity.Quiz;
import com.quiz.backpro.exception.ResourceNotFoundException;
import com.quiz.backpro.repository.QuestionRepo;
import com.quiz.backpro.repository.QuizRepo;
import com.quiz.backpro.services.QuestionService;

@Service
public class QuestionImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepo.save(question);
	}

	@Override
	public Question getQuestion(Integer id) {
		return this.questionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("questionimpl", "question_get", id));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Integer id) {
		Quiz quiz = this.quizRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("questionimpl", "questionOfQuiz", id));
		List<Question> questionList = this.questionRepo.findByQuiz(quiz);
		return questionList;
	}

}
