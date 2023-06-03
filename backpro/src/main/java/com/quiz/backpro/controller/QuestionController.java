package com.quiz.backpro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.backpro.entity.Question;
import com.quiz.backpro.entity.Quiz;
import com.quiz.backpro.services.QuestionService;
import com.quiz.backpro.services.QuizService;
import com.quiz.backpro.services.impl.QuestionImpl;
import com.quiz.backpro.services.impl.QuizImpl;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class QuestionController {

	@Autowired
	private QuestionService services;
	
	@Autowired
	private QuizService quizService;
	
	@Autowired
	private QuizImpl quizImpl;
	
	// to add a question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		Question addedQuestion = this.services.addQuestion(question);
		return new ResponseEntity<Question>(addedQuestion, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
	{
		Question updatedQuestion = this.services.updateQuestion(question);
		return new ResponseEntity<Question>(updatedQuestion, HttpStatus.OK);
	}
	
	@GetMapping("/{queId}")
	public ResponseEntity<Question> getQuestion(@PathVariable("queId") Integer queId)
	{
		Question question = this.services.getQuestion(queId);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	
	//get all question of a quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable Integer quizId)
	{
		List<Question> questionsOfQuiz = this.services.getQuestionsOfQuiz(quizId);
		return new ResponseEntity<List<Question>>(questionsOfQuiz, HttpStatus.OK);
	}
}
