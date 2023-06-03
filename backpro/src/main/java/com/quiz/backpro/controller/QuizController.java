package com.quiz.backpro.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.quiz.backpro.entity.Quiz;
import com.quiz.backpro.services.QuizService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class QuizController {
	@Autowired
	private QuizService services;
	
	//add quiz
	@PostMapping("quizzes")
	
	public ResponseEntity<Quiz> addQuiz(@Validated @RequestBody Quiz quiz)
	{
//		// Add CORS headers to the response
//	    response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//	    response.setHeader("Access-Control-Allow-Methods", "POST");
//	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
//	    response.setHeader("Access-Control-Max-Age", "3600");
	    
		Quiz addedQuiz = this.services.addQuiz(quiz);
		return new ResponseEntity<>(addedQuiz,HttpStatus.CREATED);
	}
	
	//update quiz
	@PutMapping("quizzes")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		Quiz addedQuiz = this.services.updateQuiz(quiz);
		return ResponseEntity.ok(addedQuiz);
	}
	
	//get a single quiz by its id;
	@GetMapping("quizzes/{quizId}")
	public Quiz getQuiz(@PathVariable Integer quizId)
	{
		return this.services.getQuiz(quizId);
	}
	
	//retrieve all quizes;
	@GetMapping("quizzes/all")
	public ResponseEntity<?> getAllQuizes()
	{
		return ResponseEntity.ok(this.services.getQuizzes());
	}
	
	@GetMapping("quizzes/active")
	public ResponseEntity<List<Quiz>> getActiveQuiz()
	{
		return ResponseEntity.ok(this.services.getActiveQuizzes());
	}
}
