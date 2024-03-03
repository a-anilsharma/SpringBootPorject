 package com.ExamPortalBackEnd.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	//Add category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		
	   return	ResponseEntity.ok( this.categoryService.addCategory(category));
		
	}
	
	//get update category
	@PutMapping("/")
	public Category updateCategory(Category category) {
		
	   return	categoryService.updateCategory(category);
	   
	}
	
	
	//get Category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		
		return this.categoryService.getCategory(categoryId);
	} 
	
	//get All Category
	@CrossOrigin("*")
	@GetMapping("/")
	public  ResponseEntity<?>  getAllCategory() {
		
		return  ResponseEntity.ok(this.categoryService.getAllCategory()); 
	} 
	
	

//Delete Category
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		
		 this.categoryService.deleteCategory(categoryId);
		
	} 
	

}
