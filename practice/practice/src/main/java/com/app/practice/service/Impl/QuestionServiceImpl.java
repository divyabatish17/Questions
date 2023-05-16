package com.app.practice.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.practice.dto.QuestionDTO;
import com.app.practice.dto.QuestionIdDTO;
import com.app.practice.dto.QuestionRequestDTO;
import com.app.practice.dto.QuestionResponseDTO;
import com.app.practice.rest.RestClient;
import com.app.practice.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	RestClient restClient;
	
	public List<QuestionDTO> getAll(){
		return restClient.fetchAll();
	}
	
	public List<QuestionIdDTO> getQuestionAndId(){
		List<QuestionDTO> fetchAllDetails=restClient.fetchAll();
		List<QuestionIdDTO> fetchAllQuestionAndId=new ArrayList<>();
		for(QuestionDTO questionDTO:fetchAllDetails) {
			QuestionIdDTO questionIdDTO=new QuestionIdDTO();
			questionIdDTO.setId(questionDTO.getId());
			questionIdDTO.setQuestion(questionDTO.getQuestion());
			fetchAllQuestionAndId.add(questionIdDTO);
		}
		return fetchAllQuestionAndId;
	}
	
	public List<QuestionResponseDTO> create(QuestionRequestDTO questionRequestDTO){
		List<QuestionDTO> fetchAllDetails=restClient.fetchAll();
		
		List<QuestionResponseDTO> fetchAllQuestionAndId=new ArrayList<>();
		
		for(QuestionDTO questionDTO:fetchAllDetails) {
			
			if(questionDTO.getAnswer().equals(questionRequestDTO.getAnswer())) {
			QuestionResponseDTO questionResponseDTO=new QuestionResponseDTO();
			questionResponseDTO.setCorrect_answer(questionDTO.getAnswer());
			
			QuestionIdDTO questionIdDTO=new QuestionIdDTO();
			questionIdDTO.setId(questionDTO.getId());
			questionIdDTO.setQuestion(questionDTO.getQuestion());
			questionResponseDTO.setNext_question(questionIdDTO);
			fetchAllQuestionAndId.add(questionResponseDTO);
			}
		}
		return fetchAllQuestionAndId;
	}
}
