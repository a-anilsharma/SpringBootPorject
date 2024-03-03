package com.ExamPortalBackEnd.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.Exam.Question;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	
	Set<Question> findByQuiz(Quiz quiz);
	
	

}
