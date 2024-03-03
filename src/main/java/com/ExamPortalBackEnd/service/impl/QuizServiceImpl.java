package com.ExamPortalBackEnd.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortalBackEnd.Entity.Exam.Quiz;
import com.ExamPortalBackEnd.repo.QuizRepository;
import com.ExamPortalBackEnd.service.QuizService;

@Service
public class QuizServiceImpl  implements QuizService{

	@Autowired
	 private QuizRepository quizRepository;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
	
		return  quizRepository.save(quiz);
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		System.out.println(" In Quiz Service");
	
		return  quizRepository.findById(quizId).get();
	}

	@Override
	public Set<Quiz> getAllQuizzes() {
		
		return  new HashSet<>(quizRepository.findAll()) ; 
	}

	@Override
	public void deleteQuiz(Long quizId) {
		quizRepository.deleteById(quizId);
		
	}
	
	
	

}
