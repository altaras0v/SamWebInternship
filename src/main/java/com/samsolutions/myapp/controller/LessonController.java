package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.model.Course;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.service.LessonService;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.validator.LessonValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for lesson
 * courseId - id of course that have this lesson
 */
@Controller
@SessionAttributes("courseId")
public class LessonController {


	private static final Logger logger = LoggerFactory.getLogger(LessonController.class);
	private final LessonDAOService lessonDAOService;
	private final LessonValidator lessonValidator;
	private final LessonService lessonService;

	/**
	 * Constructor for controller
	 *
	 * @param lessonDAOService - service for lesson, getting,adding and deleting lesson
	 * @param lessonValidator - validator for lesson
	 * @param lessonService - service for lesson
	 */
	@Autowired
	public LessonController(LessonDAOService lessonDAOService, LessonValidator lessonValidator, LessonService lessonService) {
		this.lessonDAOService = lessonDAOService;
		this.lessonValidator = lessonValidator;
		this.lessonService = lessonService;
	}

	/**
	 * Send to JSP lessonDTO (empty) for adding later
	 *
	 * @return mav - lessonDTO
	 */
	@RequestMapping(value = "/addLesson", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute LessonDTO lessonDTO, ModelMap model) {
		ModelAndView mav = new ModelAndView("addLesson");
		long id = Long.parseLong(request.getParameter("courseId"));
		model.addAttribute("courseId", id);
		mav.addObject("lesson", new LessonDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	/**
	 * Add course to database
	 *
	 * @param lessonDTO - LessonDTO(empty) that will be add
	 * @return - view where adding course
	 */
	@RequestMapping(value = "/addLesson", method = RequestMethod.POST)
	public ModelAndView addLesson(@ModelAttribute("lesson") LessonDTO lessonDTO, ModelMap modelMap, BindingResult result) {
		ModelAndView mav = new ModelAndView("addLesson");
		lessonValidator.validate(lessonDTO, result);
		if (result.hasErrors()) {
			logger.info("lesson validate method error so" + result);
			mav.addObject("lesson", lessonDTO);
		}
		else {
			long id = (long) modelMap.get("courseId");
			Course course = new Course();
			course.setId(id);
			lessonDAOService.addLesson(new Lesson(lessonDTO.getName(), lessonDTO.getDescription(), course));
		}
		return mav;
	}

	/**
	 * Show list of lesson for deleting
	 *
	 * @param request - course id, lessons of this course will be delete
	 * @return page for lesson deleting
	 */
	@RequestMapping(value = "/deleteLesson", method = RequestMethod.GET)
	public ModelAndView showLessonList(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("deleteLesson");
		long id = Long.parseLong(request.getParameter("courseId"));
		List<LessonDTO> lessonDTOList = lessonDAOService.getLessonsByCourseId(id);
		modelAndView.addObject("lessonDTOList", lessonDTOList);
		modelAndView.addObject("courseId", id);
		return modelAndView;
	}

	/**
	 * Delete lesson from database
	 *
	 * @param request - lesson id
	 * @return page for lesson deleting
	 */
	@RequestMapping(value = "/deleteLesson", method = RequestMethod.POST)
	public ModelAndView deleteLesson(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning/deleteLesson"));
		long id = Long.parseLong(request.getParameter("lessonId"));

		lessonService.deleteIfLessonExist(id);

		return modelAndView;
	}


}
