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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/redirect")
public class RedirectToLessonController {

	private static final Logger logger = LoggerFactory.getLogger(RedirectToLessonController.class);

	@Autowired
	private LessonService lessonService;

	@Autowired
	private LessonFileService lessonFileService;

	@RequestMapping(value = {"/lessonRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToLesson(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));

		LessonDTO lessonDTO = lessonService.getLessonById(id);
		List<LessonFileDTO> listFiles = lessonFileService.getFilesByLessonId(id);

		ModelAndView modelAndView = new ModelAndView("lesson");
		modelAndView.addObject("lessonDTO", lessonDTO);
		modelAndView.addObject("listFiles", listFiles);

		logger.info("redirect to lesson controller");

		return modelAndView;

	}

}
