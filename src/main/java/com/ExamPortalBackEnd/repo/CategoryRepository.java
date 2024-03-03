package com.ExamPortalBackEnd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamPortalBackEnd.Entity.Exam.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
