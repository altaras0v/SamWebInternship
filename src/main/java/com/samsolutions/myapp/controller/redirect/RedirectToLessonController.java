package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.service.api.LessonFileService;
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
 * Controller for lesson
 * Return lesson page
 * Generate the page that user choosed
 */
@Controller
@RequestMapping("/redirect")
public class RedirectToLessonController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToLessonController.class);

	private final LessonService lessonService;

	private final LessonFileService lessonFileService;


	/**
	 * Constructor for controller
	 * @param lessonService - service for lesson, used for getting lesson DTO
	 * @param lessonFileService - service fro files, used for getting files for this lesson
	 */
	@Autowired
	public RedirectToLessonController(LessonService lessonService, LessonFileService lessonFileService) {
		this.lessonService = lessonService;
		this.lessonFileService = lessonFileService;
	}

	/**
	 * Method that takes lesson id, get entity from database (with this id)
	 * And send DTO to view
	 * @param request - id of lesson
	 * @return - view with lessonDTO and list with files of this lesson
	 */
	@RequestMapping(value = {"/lessonRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToLesson(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));

		LessonDTO lessonDTO = lessonService.getLessonById(id);
		List<LessonFileDTO> listFiles = lessonFileService.getFilesByLessonId(id);
		//TestDTO testDTO = testService.getTestByLessonId(id);

		ModelAndView modelAndView = new ModelAndView("lesson");
		modelAndView.addObject("lessonDTO", lessonDTO);
		modelAndView.addObject("listFiles", listFiles);
		//modelAndView.addObject("testDTO",testDTO);

		logger.info("redirect to lesson controller");

		return modelAndView;

	}

}
