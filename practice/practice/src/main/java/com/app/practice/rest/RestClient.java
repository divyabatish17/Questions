package com.app.practice.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.practice.dto.QuestionDTO;

@Component
public class RestClient {
	
	public static final String GET_ALL="https://jservice.io/api/random";

	@Autowired
	@Qualifier("restWebClient")
	private WebClient webClient;

	public RestClient() {

	}

	public RestClient(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public List<QuestionDTO> fetchAll(){
		return webClient.get().uri(GET_ALL).retrieve().bodyToFlux(QuestionDTO.class).collectList().block();
	}
	
	
}
