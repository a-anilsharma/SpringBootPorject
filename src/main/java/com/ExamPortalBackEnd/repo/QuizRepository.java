package com.ExamPortalBackEnd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.Exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
