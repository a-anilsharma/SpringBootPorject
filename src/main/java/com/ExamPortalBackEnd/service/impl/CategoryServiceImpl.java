package com.ExamPortalBackEnd.service.impl;


import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.repo.CategoryRepository;
import com.ExamPortalBackEnd.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		categoryRepository.save(category);
	 
		return category;
	}

	@Override
	public Category updateCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}

	@Override
	public Category getCategory(Long categoryid) {
	   
		return  categoryRepository.findById(categoryid).get() ;
	}

	@Override
	public Set<Category> getAllCategory() {
		
		return  new LinkedHashSet<>( categoryRepository.findAll());
	}

	@Override
	public void deleteCategory(Long categoryid) {
		 categoryRepository.deleteById(categoryid);
		
	}

	
	

}
