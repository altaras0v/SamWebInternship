package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.AnswerDTO;
import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.service.api.AnswerDAOService;
import com.samsolutions.myapp.service.api.ContactDAOService;
import com.samsolutions.myapp.service.api.FileDAOService;
import com.samsolutions.myapp.service.api.LessonDAOService;
import com.samsolutions.myapp.service.api.QuestionDAOService;
import com.samsolutions.myapp.service.api.ResultDAOService;
import com.samsolutions.myapp.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Transactional
public class LessonService {

	private final LessonDAOService lessonDAOService;

	private final FileDAOService fileDAOService;

	private final TestService testService;

	private final QuestionDAOService questionDAOService;

	private final UserService userService;

	private final ResultDAOService resultDAOService;

	private final AnswerDAOService answerDAOService;

	private final ContactDAOService contactDAOService;

	@Autowired
	public LessonService(LessonDAOService lessonDAOService, FileDAOService fileDAOService, TestService testService, QuestionDAOService questionDAOService, UserService userService, ResultDAOService resultDAOService, AnswerDAOService answerDAOService, ContactDAOService contactDAOService) {
		this.lessonDAOService = lessonDAOService;
		this.fileDAOService = fileDAOService;
		this.testService = testService;
		this.questionDAOService = questionDAOService;
		this.userService = userService;
		this.resultDAOService = resultDAOService;
		this.answerDAOService = answerDAOService;
		this.contactDAOService = contactDAOService;
	}

	public ModelAndView getFullLesson(long id, String viewName) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject(lessonDAOService.getLessonById(id));


		modelAndView.addObject("lessonDTO", lessonDAOService.getLessonById(id));
		modelAndView.addObject("listFiles", fileDAOService.getFilesByLessonId(id));
		modelAndView.addObject("testDTO", testService.getTestByLessonId(id));
		modelAndView.addObject("listQuestion", questionDAOService.getQuestionsByTestId(testService.getTestByLessonId(id)
				.getId()));
		modelAndView.addObject("auth", userService.getUserAuth());
		modelAndView.addObject("answer", new AnswerDTO());
		List<Contact> contacts = contactDAOService.getAllContact();

		User user = (User) userService.getUserAuth()
				.getPrincipal();
		modelAndView.addObject("contactCheck",ifContact(user,contacts));


		return modelAndView;
	}

	private boolean ifContact(User user, List<Contact> contacts) {
		boolean flag = false;
		for (Contact contact : contacts) {
			if (contact.getUser()
					.getName()
					.equals(user.getUsername())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean deleteIfLessonExist(long id){
		boolean flag = false;
		for (long lessonId : lessonDAOService.getLessonsId()) {
			if (lessonId == id) {
				lessonDAOService.deleteLesson(id);
				flag = true;
				break;
			}
		}
		return flag;
	}
}
