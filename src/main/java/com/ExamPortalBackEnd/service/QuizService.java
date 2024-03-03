package com.ExamPortalBackEnd.service;

import java.util.Set;

import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Quiz getQuiz(Long quizId);
	public Set<Quiz> getAllQuizzes();
	public void deleteQuiz(Long quizId);

}
