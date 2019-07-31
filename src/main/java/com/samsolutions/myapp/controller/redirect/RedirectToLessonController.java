package com.samsolutions.myapp.controller.redirect;

import com.samsolutions.myapp.dto.LessonDTO;
import com.samsolutions.myapp.dto.LessonFileDTO;
import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.dto.TestDTO;
import com.samsolutions.myapp.service.api.FileService;
import com.samsolutions.myapp.service.api.LessonService;
import com.samsolutions.myapp.service.api.QuestionService;
import com.samsolutions.myapp.service.api.TestService;
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


	private final FileService fileService;

	private final TestService testService;

	private final QuestionService questionService;


	/**
	 * Constructor for controller
	 *
	 * @param lessonService     - service for lesson, used for getting lesson DTO
	 * @param fileService - service for files, used for getting files for this lesson
	 * @param testService       - service for test, used for getting test for this lesson(if it exist)
	 * @param questionService   - service for question, used for getting question for test
	 */
	@Autowired
	public RedirectToLessonController(LessonService lessonService, FileService fileService, TestService testService,
									  QuestionService questionService) {
		this.lessonService = lessonService;
		this.fileService = fileService;
		this.testService = testService;
		this.questionService = questionService;
	}

	/**
	 * Method that takes lesson id, get entity from database (with this id)
	 * And send DTO to view
	 *
	 * @param request - id of lesson
	 * @return - view with lessonDTO and list with files and test(if it exist) of this lesson
	 */
	@RequestMapping(value = {"/lessonRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToLesson(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("lesson");

		int id = Integer.parseInt(request.getParameter("id"));
		LessonDTO lessonDTO = lessonService.getLessonById(id);
		List<LessonFileDTO> listFiles = fileService.getFilesByLessonId(id);
		TestDTO testDTO = testService.getTestByLessonId(id);
		List<QuestionDTO> questionDTOList = questionService.getQuestionsByTestId(testDTO.getId());
		modelAndView.addObject("testDTO", testDTO);
		modelAndView.addObject("lessonDTO", lessonDTO);
		modelAndView.addObject("listFiles", listFiles);
		modelAndView.addObject("listQuestion",questionDTOList);

		logger.info("redirect to lesson controller");

		return modelAndView;

	}

}
