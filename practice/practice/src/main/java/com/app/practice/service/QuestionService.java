package com.app.practice.service;

import java.util.List;

import com.app.practice.dto.QuestionDTO;
import com.app.practice.dto.QuestionIdDTO;
import com.app.practice.dto.QuestionRequestDTO;
import com.app.practice.dto.QuestionResponseDTO;

public interface QuestionService {

	public List<QuestionDTO> getAll();
	public List<QuestionIdDTO> getQuestionAndId();
	public List<QuestionResponseDTO> create(QuestionRequestDTO questionRequestDTO);
}
