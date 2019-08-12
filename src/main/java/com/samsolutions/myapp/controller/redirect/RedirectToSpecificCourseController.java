package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for lesson list
 * User choosed course in mainpage and it redirect to page with lessons for this course
 */
@Controller
@RequestMapping("/redirect")
public class RedirectToSpecificCourseController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToSpecificCourseController.class);

	private final CourseService courseService;

	/**
	 * Constructor for controller
	 *
	 * @param courseService - service for course,getting course by lesson id
	 */

	public RedirectToSpecificCourseController(CourseService courseService) {

		this.courseService = courseService;
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

		logger.info("redirect to lessons list controller");

		return courseService.getFullCourse(id,"mainlesson") ;

	}
}
