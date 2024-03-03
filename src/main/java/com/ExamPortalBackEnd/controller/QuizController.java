package com.ExamPortalBackEnd.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;
import com.ExamPortalBackEnd.service.CategoryService;
import com.ExamPortalBackEnd.service.QuizService;


@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	
	//Add category
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Quiz quiz) {
		
	   return	ResponseEntity.ok( this.quizService.addQuiz(quiz));
		
	}
	
	//get update category
	@PutMapping("/")
	public Quiz updateQuiz(Quiz quiz) {
		
	   return	this.quizService.updateQuiz(quiz);
	   
	}
	
	//get Category
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		System.out.println("Quiz in controller");
		return this.quizService.getQuiz(quizId);
	} 
	
	//get All Category
	@GetMapping("/")
	public  ResponseEntity<?>  getAllQuizzes() {
		
		return  ResponseEntity.ok(this.quizService.getAllQuizzes()); 
	} 
	
	

//Delete Category
	@DeleteMapping("/{quizId}")
	public void deleteCategory(@PathVariable("quizId") Long quizId) {
		System.out.println("In delete deleteCategory method");
		 this.quizService.deleteQuiz(quizId);
		
	} 
	

	
}


