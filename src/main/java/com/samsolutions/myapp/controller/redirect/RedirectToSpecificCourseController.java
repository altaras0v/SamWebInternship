package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.service.api.CourseService;
import com.samsolutions.myapp.service.api.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for lesson list
 * User choosed course in mainpage and it redirect to page with lessons for this course
 */
@Controller
@RequestMapping("/redirect")
public class RedirectToSpecificCourseController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToSpecificCourseController.class);

	private final CourseService courseService;

	private final LessonService lessonService;

	/**
	 * Constructor for controller
	 *
	 * @param courseService - service for course,getting course by lesson id
	 * @param lessonService - service for lesson,getting lessons for this course
	 */
	@Autowired
	public RedirectToSpecificCourseController(CourseService courseService, LessonService lessonService) {
		this.courseService = courseService;
		this.lessonService = lessonService;
	}

	/**
	 * Method that takes course id, get entity from database (with this id)
	 * And send DTO to view
	 * @param request - course id
	 * @return - view with list of lesson for this course
	 */
	@RequestMapping(value = {"/courseRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToCourse(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("first"));

		CourseDTO courseDTO = courseService.getCourseById(id);
		List<LessonDTO> listLesson = lessonService.getLessonsByCourseId(id);

		ModelAndView modelAndView = new ModelAndView("mainlesson");
		modelAndView.addObject("listLesson", listLesson);
		modelAndView.addObject("courseDTO", courseDTO);

		logger.info("redirect to lessons list controller");

		return modelAndView;

	}
}
