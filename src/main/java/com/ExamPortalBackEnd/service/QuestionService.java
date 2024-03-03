package com.ExamPortalBackEnd.service;

import java.util.Set;

import com.ExamPortalBackEnd.Entity.Exam.Question;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Question getQuestion(Long questionId);
	public Set<Question> getAllQuestions();
	public void deleteQuestion(Long QuestionId);
	public Set<Question> getQuestionOfQuiz(Quiz quiz);
	

}
