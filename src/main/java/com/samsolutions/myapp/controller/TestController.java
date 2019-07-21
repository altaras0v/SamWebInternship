package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("testId")
public class TestController	 {

	@Autowired
	private final TestService testService;


	public TestController(TestService testService) {
		this.testService = testService;
	}
	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute LessonDTO lessonDTO, ModelMap model) {
		ModelAndView mav = new ModelAndView("addTest");
		long id = Long.parseLong(request.getParameter("lessonId"));
		System.out.println(id);
		model.addAttribute("lessonId",id);
		mav.addObject("lesson", new LessonDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	/*@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public ModelAndView AddCourse(@ModelAttribute("lesson") LessonDTO lessonDTO, ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("addLesson");
		long id = (long)modelMap.get("courseId");
		Course course = new Course();
		course.setId(id);
		lessonService.addLesson(new Lesson(lessonDTO.getName(),lessonDTO.getDescription(),course));
		return mav;
	}*/

	}

