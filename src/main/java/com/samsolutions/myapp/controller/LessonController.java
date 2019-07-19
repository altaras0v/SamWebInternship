package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Course;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.service.api.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("courseId")
public class LessonController {
// TODO: 19.07.2019 add comments 
	
	private final LessonService lessonService;

	@Autowired
	public LessonController(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	/**
	 * Send to JSP DTO
	 * @return mav - lessonDTO
	 */
	@RequestMapping(value = "/addLesson", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request,@ModelAttribute LessonDTO lessonDTO, ModelMap model) {
		ModelAndView mav = new ModelAndView("addLesson");
		long id = Long.parseLong(request.getParameter("courseId"));
		model.addAttribute("courseId",id);
		mav.addObject("lesson", new LessonDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	/**
	 * Add course to database
	 * @param lessonDTO - LessonDTO
	 * @return - view where adding course
	 */
	@RequestMapping(value = "/addLesson", method = RequestMethod.POST)
	public ModelAndView AddCourse(@ModelAttribute("lesson") LessonDTO lessonDTO, ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("addLesson");
		long id = (long)modelMap.get("courseId");
		Course course = new Course();
		course.setId(id);
		lessonService.addLesson(new Lesson(lessonDTO.getName(),lessonDTO.getDescription(),course));
		return mav;
	}

	@RequestMapping(value = "/deleteLesson", method = RequestMethod.GET)
	public ModelAndView showLessonList(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("deleteLesson");
		long id = Long.parseLong(request.getParameter("courseId"));
		List<LessonDTO> lessonDTOList = lessonService.getLessonsByCourseId(id);
		modelAndView.addObject("lessonDTOList", lessonDTOList);
		return modelAndView;
	}

	@RequestMapping(value = "/deleteLesson", method = RequestMethod.POST)
	public ModelAndView deleteLesson(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("deleteLesson");
		long id = Long.parseLong(request.getParameter("lessonId"));
		lessonService.deleteLesson(id);
		return modelAndView;
	}

}