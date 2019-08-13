package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.CourseDTO;
import com.samsolutions.myapp.service.UserService;
import com.samsolutions.myapp.service.api.CourseDAOService;
import com.samsolutions.myapp.validator.CourseValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for courses (courses.jsp)
 */
@Controller
public class CourseController {

	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	private final CourseDAOService courseDAOService;
	private final UserService userService;
	private final CourseValidator courseValidator;

	/**
	 * Constructor for controller
	 *
	 * @param courseDAOService - service for course,getting,adding and deleting course
	 * @param courseValidator  - validator for course
	 */
	@Autowired
	public CourseController(CourseDAOService courseDAOService, UserService userService, CourseValidator courseValidator) {
		this.courseDAOService = courseDAOService;
		this.userService = userService;
		this.courseValidator = courseValidator;
	}

	/**
	 * Get courses from database and set them to list
	 *
	 * @return modelAndView - list of courses
	 */
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView getCourse() {
		List<CourseDTO> listCourses = courseDAOService.getCourses();

		ModelAndView modelAndView = new ModelAndView("courses");

		modelAndView.addObject("listsCourses", listCourses);
		modelAndView.addObject("auth", userService.getUserAuth());
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


	/**
	 * Add course to database
	 *
	 * @param course - CourseDTO
	 * @return - view where adding course(course add now)
	 */
	@RequestMapping(value = "/addCourse", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	public ModelAndView addCourse(@ModelAttribute("course") CourseDTO course, BindingResult result) {
		ModelAndView mav = new ModelAndView("addCourse");

		courseValidator.validate(course,result);
		if (result.hasErrors()) {
			logger.info("lesson validate method error so" + result);
			mav.addObject("course", new CourseDTO());
		}
		else {
			courseDAOService.addCourse(course);
			}
		return mav;
		}

		/**
		 * Send to JSP list with courseDTOs
		 *
		 * @return - view for deleting course with courseDTOs(like list)
		 */
		@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET) public ModelAndView showCourseList () {
			ModelAndView mav = new ModelAndView("deleteCourse");
			List<CourseDTO> courseDTOList = courseDAOService.getCourses();
			mav.addObject("courseDTOList", courseDTOList);
			return mav;
		}

		/**
		 * Delete course to database
		 *
		 * @return - view where deleting course (course delete now)
		 */
		@RequestMapping(value = "/deleteCourse", method = RequestMethod.POST) public ModelAndView deleteCourse
		(HttpServletRequest request)
		{
			ModelAndView mav = new ModelAndView(new RedirectView("/elearning/deleteCourse"));
			long id = Long.parseLong(request.getParameter("courseId"));
			courseDAOService.deleteIfCourseExist(id);
			return mav;
		}
	}