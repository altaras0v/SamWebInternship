package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.service.LessonService;
import com.samsolutions.myapp.service.UserService;
import com.samsolutions.myapp.service.api.AnswerDAOService;
import com.samsolutions.myapp.service.api.FileDAOService;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.service.api.QuestionDAOService;
import com.samsolutions.myapp.service.api.ResultDAOService;
import com.samsolutions.myapp.service.api.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for lesson
 * Return lesson page
 * Generate the page that user choosed
 */
@Controller
@RequestMapping("/redirect")
public class RedirectToLessonController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToLessonController.class);

	private final LessonService lessonService;
	//////////////////////////////////////////////////////////////
	private final LessonDAOService lessonDAOService;
	private final FileDAOService fileDAOService;
	private final TestService testService;
	private final QuestionDAOService questionDAOService;
	private final UserService userService;
	private final ResultDAOService resultDAOService;
	private final AnswerDAOService answerDAOService;
//////////////////////////////////////////////////////////////////
	/**
	 * Constructor for controller
	 *
	 * @param lessonService     - service for lesson, used for getting lesson DTO
	 */
	@Autowired
	public RedirectToLessonController(LessonService lessonService, LessonDAOService lessonDAOService, FileDAOService fileDAOService, TestService testService, QuestionDAOService questionDAOService, UserService userService, ResultDAOService resultDAOService, AnswerDAOService answerDAOService) {
		this.lessonService = lessonService;
		this.lessonDAOService = lessonDAOService;
		this.fileDAOService = fileDAOService;
		this.testService = testService;
		this.questionDAOService = questionDAOService;
		this.userService = userService;
		this.resultDAOService = resultDAOService;
		this.answerDAOService = answerDAOService;
	}

	/**
	 * Method that takes lesson id, get entity from database (with this id)
	 * And send DTO to view
	 *
	 * @param request - id of lesson
	 * @return - view with lessonDTO and list with files and test(if it exist) of this lesson
	 */
	@RequestMapping(value = {"/lessonRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToLesson(HttpServletRequest request) {
		logger.info("redirect to lesson controller");
		int id = Integer.parseInt(request.getParameter("id"));


		return lessonService.getFullLesson(id,"lesson");
	}


}
