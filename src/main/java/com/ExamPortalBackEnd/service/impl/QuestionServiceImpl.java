package com.ExamPortalBackEnd.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortalBackEnd.Entity.Exam.Question;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;
import com.ExamPortalBackEnd.repo.QuestionRepository;
import com.ExamPortalBackEnd.service.QuestionService;

@Service
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
	
		return  questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
	
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestion(Long questionId) {
	
		return  questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getAllQuestions() {

		return  new HashSet<>( questionRepository.findAll());
	}

	@Override
	public void deleteQuestion(Long QuestionId) {

		questionRepository.deleteById(QuestionId);
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		
		
		return questionRepository.findByQuiz(quiz);
	}
	

}
