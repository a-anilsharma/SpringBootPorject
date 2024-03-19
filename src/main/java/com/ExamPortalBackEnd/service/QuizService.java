package com.ExamPortalBackEnd.service;

import java.util.List;
import java.util.Set;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Quiz getQuiz(Long quizId);
	public Set<Quiz> getAllQuizzes();
	public void deleteQuiz(Long quizId);
	
	public List<Quiz> getQuizzesOfCategory(Category category);
	public List<Quiz> getActiveQuizzes();
	public List<Quiz> getActiveQuizzesOfCategory(Category category);
	

}
