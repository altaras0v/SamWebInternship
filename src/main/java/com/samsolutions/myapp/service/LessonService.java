package com.samsolutions.myapp.service;

import com.samsolutions.myapp.service.api.FileDAOService;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.service.api.QuestionDAOService;
import com.samsolutions.myapp.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class LessonService {

	private final LessonDAOService lessonDAOService;

	private final FileDAOService fileDAOService;

	private final TestService testService;

	private final QuestionDAOService questionDAOService;

	private final UserService userService;

	@Autowired
	public LessonService(LessonDAOService lessonDAOService, FileDAOService fileDAOService, TestService testService, QuestionDAOService questionDAOService, UserService userService) {
		this.lessonDAOService = lessonDAOService;
		this.fileDAOService = fileDAOService;
		this.testService = testService;
		this.questionDAOService = questionDAOService;
		this.userService = userService;
	}

	public ModelAndView getFullLesson(long id, String viewName){
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject(lessonDAOService.getLessonById(id));


		modelAndView.addObject("lessonDTO",lessonDAOService.getLessonById(id));
		modelAndView.addObject("listFiles",fileDAOService.getFilesByLessonId(id));
		modelAndView.addObject("testDTO",testService.getTestByLessonId(id));
		modelAndView.addObject("listQuestion",questionDAOService.getQuestionsByTestId(testService.getTestByLessonId(id).getId()));
		modelAndView.addObject("auth",userService.getUserAuth());

		return modelAndView;
	}
}
