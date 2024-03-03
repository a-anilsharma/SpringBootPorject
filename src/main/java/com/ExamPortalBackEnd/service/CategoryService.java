package com.ExamPortalBackEnd.service;

import java.util.Set;

import com.ExamPortalBackEnd.Entity.Exam.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Category getCategory(Long categoryid);
	public Set<Category> getAllCategory();
	public void deleteCategory(Long categoryid);
	
	
}
