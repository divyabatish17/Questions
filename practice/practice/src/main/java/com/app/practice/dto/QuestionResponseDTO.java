package com.app.practice.dto;

public class QuestionResponseDTO {

	private String correct_answer;
	private QuestionIdDTO next_question;
	
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}
	public QuestionIdDTO getNext_question() {
		return next_question;
	}
	public void setNext_question(QuestionIdDTO next_question) {
		this.next_question = next_question;
	}
	
	
}
