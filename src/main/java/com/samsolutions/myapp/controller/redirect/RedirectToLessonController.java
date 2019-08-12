package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.service.LessonService;
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

	/**
	 * Constructor for controller
	 *
	 * @param lessonService     - service for lesson, used for getting lesson DTO
	 */
	@Autowired
	public RedirectToLessonController(LessonService lessonService) {
		this.lessonService = lessonService;
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
		int id = Integer.parseInt(request.getParameter("id"));
		logger.info("redirect to lesson controller");
		return lessonService.getFullLesson(id,"lesson");
	}

}
