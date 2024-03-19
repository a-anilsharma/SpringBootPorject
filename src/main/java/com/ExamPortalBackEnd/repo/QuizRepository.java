package com.ExamPortalBackEnd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	public List<Quiz> findByCategory(Category category);
	public List<Quiz> findByActive(boolean  b);
	public List<Quiz> findByCategoryAndActive(Category category, boolean  b);
}
