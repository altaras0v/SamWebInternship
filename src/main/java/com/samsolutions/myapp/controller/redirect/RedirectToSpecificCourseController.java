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

@Controller
@RequestMapping("/redirect")
public class RedirectToSpecificCourseController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToSpecificCourseController.class);

	@Autowired
	private CourseService courseService;

	@Autowired
	private LessonService lessonService;

	@RequestMapping(value = {"/courseRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToCourse(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("first"));

		CourseDTO courseDTO = courseService.getCourseById(id);
		List<LessonDTO> listLesson = lessonService.getLessonsByCourseId(id);

		ModelAndView modelAndView = new ModelAndView("specificCourse");
		modelAndView.addObject("listLesson", listLesson);
		modelAndView.addObject("courseDTO", courseDTO);

		logger.info("redirect to lessons list controller");

		return modelAndView;

	}
}
