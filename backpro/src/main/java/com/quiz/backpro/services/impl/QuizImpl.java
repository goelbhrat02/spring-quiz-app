package com.quiz.backpro.services.impl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.backpro.entity.Quiz;
import com.quiz.backpro.exception.ResourceNotFoundException;
import com.quiz.backpro.repository.QuestionRepo;
import com.quiz.backpro.repository.QuizRepo;
import com.quiz.backpro.services.QuizService;

@Service
public class QuizImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz)
	{
		return this.quizRepo.save(quiz);
	}
	
	@Override
	public List<Quiz> getQuizzes() {
		return this.quizRepo.findAll();		
	}
	
	@Override
	public List<Quiz> getActiveQuizzes()
	{
		List<Quiz> activeQuizzes = this.quizRepo.findByStatus(true);
		return activeQuizzes;
	}

	@Override
	public Quiz getQuiz(Integer qid) {
		return this.quizRepo.findById(qid).orElseThrow(()-> new ResourceNotFoundException("quiz", "getQuiz", qid));
	}

	@Override
	public void updateQuizStatus(LocalDateTime currentDateTime) {
        List<Quiz> quizzes = this.quizRepo.findAll();
        for (Quiz quiz : quizzes) {
            LocalDateTime startDate = LocalDateTime.parse(quiz.getStartDate());
            LocalDateTime endDate = LocalDateTime.parse(quiz.getEndDate());
            boolean status;

           
            if (currentDateTime.isEqual(startDate) || currentDateTime.isBefore(endDate)) {
                status = true;
            } else {
                status = false;
            }

            quiz.setStatus(status);
            this.quizRepo.save(quiz);
        }
    }
//	@Override
//	public Set<Quiz> getActiveQuiz() {
//		return new HashSet<>(this.quizRepo.findByActive(true));
//	}

}
