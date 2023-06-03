package com.quiz.backpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackproApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackproApplication.class, args);
		System.out.println("java project started.............!!!!!!!!!!!!");
	}
}
