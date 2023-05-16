package com.app.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.practice.dto.QuestionDTO;
import com.app.practice.dto.QuestionIdDTO;
import com.app.practice.dto.QuestionRequestDTO;
import com.app.practice.dto.QuestionResponseDTO;
import com.app.practice.service.QuestionService;
import com.exception.BadRequestAlertException;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("/all")
	public ResponseEntity<Object> getAll(){
		try {
			List<QuestionDTO> result = questionService.getAll();
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	}
	
	@GetMapping("/play")
	public ResponseEntity<Object> getAllQuestionAndId(){
		try {
			List<QuestionIdDTO> result = questionService.getQuestionAndId();
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	       	}

	
	@PostMapping("/next")
	public ResponseEntity<Object> create(@RequestBody QuestionRequestDTO questionRequestDTO){
		try {
			List<QuestionResponseDTO> result = questionService.create(questionRequestDTO);
	        if(result!=null) {
	        	return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
	        }
	        else {
	        	return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("Result not present");
	        }
	        }
	        catch(Exception e) {
	        	throw new BadRequestAlertException("No result");
	        }
	}
}

