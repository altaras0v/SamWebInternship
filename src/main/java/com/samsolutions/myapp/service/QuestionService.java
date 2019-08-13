package com.samsolutions.myapp.service;

import com.samsolutions.myapp.config.ApplicationProperties;
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
	private ApplicationProperties properties = new ApplicationProperties();

	@Autowired
	public QuestionService(QuestionDAOService questionDAOService, LessonDAOService lessonDAOService) {
		this.questionDAOService = questionDAOService;
		this.lessonDAOService = lessonDAOService;
	}

	public long getLessonId(long id) {
		return lessonDAOService.getLessonByTestId(id)
				.getId();
	}

	public void addQuestion(QuestionDTO questionDTO, long id) {
		Test test = new Test();
		test.setId(id);
		questionDAOService.addQuestion(new Question(questionDTO.getQuestion(), test));
	}

	public void deleteQuestion(long id) {
		questionDAOService.deleteQuestion(id);
	}

	public boolean deleteIfQuestionExist(long id) {
		boolean flag = false;
		for (long lessonId : questionDAOService.getQuestionsId()) {
			if (lessonId == id) {
				questionDAOService.deleteQuestion(id);
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean checkQuestionsIsNotFull(long testId) {
		if (questionDAOService.getQuestionsByTestId(testId)
				.size() < Integer.parseInt(properties.getProperty("question.count"))) {
			return true;
		}
		else {
			return false;
		}
	}
}
