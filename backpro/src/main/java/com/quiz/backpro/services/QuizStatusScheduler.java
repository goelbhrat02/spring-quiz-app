package com.quiz.backpro.services;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QuizStatusScheduler {

    // Assuming you have a QuizService to update the status
    private final QuizService quizService;

    public QuizStatusScheduler(QuizService quizService) {
        this.quizService = quizService;
    }

    @Scheduled(cron = "0 * * * * *") // Runs every minute
    public void updateQuizStatus() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        quizService.updateQuizStatus(currentDateTime);
    }
}
