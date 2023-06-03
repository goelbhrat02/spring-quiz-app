package com.quiz.backpro.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@CrossOrigin("*")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer quizId;
	
	private String title;
	
	private String description;
	
	private Integer maxMarks;
	
	private String noOfQuestion;
	
	private boolean status;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = Shape.STRING)
	private String startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = Shape.STRING)
	private String endDate;
	
	@OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> questions = new ArrayList<>();
}
