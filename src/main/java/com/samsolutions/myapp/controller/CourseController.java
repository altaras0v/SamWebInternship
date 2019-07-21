package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller for courses (courses.jsp)
 */
@Controller
public class CourseController {

	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * Get courses from database and set them to list
	 *
	 * @return modelAndView - list of courses
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getCourse() {
		List<CourseDTO> listCourses = courseService.getCourses();

		ModelAndView modelAndView = new ModelAndView("mainpage");
		modelAndView.addObject("listsCourses", listCourses);
		return modelAndView;
	}

	/**
	 * Send to JSP empty courseDTO
	 *
	 * @return - view for adding course with courseDTO
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView("addCourse");
		mav.addObject("course", new CourseDTO());
		return mav;
	}
	// TODO: 21.07.2019  СДЕЛАТЬ РЕДИРЕКТ

	/**
	 * Add course to database
	 *
	 * @param course - CourseDTO
	 * @return - view where adding course(course add now)
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public ModelAndView AddCourse(@ModelAttribute("course") CourseDTO course) {
		ModelAndView mav = new ModelAndView("addCourse");
		courseService.addCourse(course);
		return mav;
	}

	/**
	 * Send to JSP list with courseDTOs
	 *
	 * @return - view for deleting course with courseDTOs(like list)
	 */
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public ModelAndView showCourseList() {
		ModelAndView mav = new ModelAndView("deleteCourse");
		List<CourseDTO> courseDTOList = courseService.getCourses();
		mav.addObject("courseDTOList", courseDTOList);
		return mav;
	}

	/**
	 * Delete course to database
	 *
	 * @return - view where deleting course (course delete now)
	 */
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST)
	public ModelAndView deleteCourse(HttpServletResponse response, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("deleteCourse");
		Long id = Long.parseLong(request.getParameter("courseId"));
		courseService.deleteCourse(id);
		return mav;
	}
}