package myapp.controller.redirect;

import myapp.dto.LessonDTO;
import myapp.dto.LessonFileDTO;
import myapp.service.api.LessonFileService;
import myapp.service.api.LessonService;
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

	@Autowired
	private LessonService lessonService;

	@Autowired
	private LessonFileService lessonFileService;

	@RequestMapping(value = {"/lessonRedirect"}, method = RequestMethod.GET)
	public ModelAndView redirectToLesson(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));

		LessonDTO lessonDTO = lessonService.getLessonsById(id);
		List<LessonFileDTO> listFiles = lessonFileService.getFilesByLessonId(id);

		ModelAndView modelAndView = new ModelAndView("lesson");
		modelAndView.addObject("lessonDTO", lessonDTO);
		modelAndView.addObject("listFiles", listFiles);

		return modelAndView;

	}

}
