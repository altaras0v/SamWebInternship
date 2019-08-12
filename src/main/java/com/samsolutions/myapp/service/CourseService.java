package com.samsolutions.myapp.service;

import com.samsolutions.myapp.service.api.CourseDAOService;
import com.samsolutions.myapp.service.api.LessonDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class CourseService {

	private final CourseDAOService courseDAOService;

	private final LessonDAOService lessonDAOService;

	private final UserService userService;

	@Autowired
	public CourseService(CourseDAOService courseDAOService, LessonDAOService lessonDAOService, UserService userService) {
		this.courseDAOService = courseDAOService;
		this.lessonDAOService = lessonDAOService;
		this.userService = userService;
	}

	public ModelAndView getFullCourse(long id, String viewName){

		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("listLesson", lessonDAOService.getLessonsByCourseId(id));
		modelAndView.addObject("courseDTO",courseDAOService.getCourseById(id));
		modelAndView.addObject("auth",userService.getUserAuth());

		return modelAndView;
	}
}
