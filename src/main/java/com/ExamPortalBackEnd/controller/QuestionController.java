package com.ExamPortalBackEnd.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ExamPortalBackEnd.Entity.Exam.Category;
import com.ExamPortalBackEnd.Entity.Exam.Question;
import com.ExamPortalBackEnd.Entity.Exam.Quiz;
import com.ExamPortalBackEnd.service.QuestionService;
import com.ExamPortalBackEnd.service.QuizService;



@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	// Add Question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	// update Question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
		
	}
	
	//get All question and quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
	
		Quiz quiz= this.quizService.getQuiz(qid);
		Set<Question> questionsOfQuiz=this.questionService.getQuestionOfQuiz(quiz);
		List list=new ArrayList<>(questionsOfQuiz);
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
			
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion())+1);
			
			
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
//		//send all question of quiz
//		Quiz quiz=new Quiz();
//		quiz.setQid(qid);
//		Set<Question> questionsOfQuiz=this.questionService.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
	}
	//get All question and quiz
		@GetMapping("/quiz/admin/{qid}")
		public ResponseEntity<?> getQuestionOfQuizForAdmin(@PathVariable("qid") Long qid){
		
					
			//send all question of quiz
			Quiz quiz=new Quiz();
			quiz.setQid(qid);
			Set<Question> questionsOfQuiz=this.questionService.getQuestionOfQuiz(quiz);
			return ResponseEntity.ok(questionsOfQuiz);
		}
	
	
	//Get single quesiton
	@GetMapping("/{qid}")
	public Question get(@PathVariable("qid") Long qid) {
		return this.questionService.getQuestion(qid);
		
	}
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		
		this.questionService.deleteQuestion(qid);
		
	}
	@PostMapping("/eval-quiz")
	public ResponseEntity<?>  evalQuiz(@RequestBody List<Question> questions){
		double marksGot=0.0;
		int correctAnswers=0;
		int attempted=0;
		for(Question q:questions) {
		
			Question question=this.questionService.getQuestion(q.getQuesId());
			
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				
				correctAnswers++;
				 double singleMarks=   Double.parseDouble(q.getQuiz().getMaxMarks())/questions.size();
				 marksGot+=	singleMarks; 
				
			}
			if(q.getGivenAnswer()!=null && !"".equals(q.getGivenAnswer().trim())) {
				attempted++;
				
			}
		}
		Map<String,Object> result=new HashMap<>();
		result.put("marksGot", marksGot);
		result.put("correctAnswers",correctAnswers);
		result.put("attempted",attempted);
		
		return ResponseEntity.ok(result);
		
	}
	
	
	
	
}
