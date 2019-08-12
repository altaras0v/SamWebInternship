package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import com.samsolutions.myapp.model.Test;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.service.api.QuestionDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionService {

	private final QuestionDAOService questionDAOService;

	private final LessonDAOService lessonDAOService;

	@Autowired
	public QuestionService(QuestionDAOService questionDAOService, LessonDAOService lessonDAOService) {
		this.questionDAOService = questionDAOService;
		this.lessonDAOService = lessonDAOService;
	}

	public long getLessonId(long id) {
		return lessonDAOService.getLessonByTestId(id).getId();
	}

	public void addQuestion(QuestionDTO questionDTO, long id){
		Test test = new Test();
		test.setId(id);
		questionDAOService.addQuestion(new Question(questionDTO.getQuestion(), test));
	}

	public void deleteQuestion(long id){
		questionDAOService.deleteQuestion(id);
	}

}
