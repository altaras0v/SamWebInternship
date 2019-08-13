package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.AnswerDTO;
import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.service.AnswerService;
import com.samsolutions.myapp.service.QuestionService;
import com.samsolutions.myapp.validator.AnswerValidator;
import com.samsolutions.myapp.validator.QuestionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for question
 * testId - id of test that have these questions
 */
@Controller
@SessionAttributes("testId")
public class QuestionController {

	private final QuestionValidator questionValidator;
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final AnswerValidator answerValidator;

	/**
	 * Constructor for controller
	 *
	 * @param questionService - service for question, adding,getting and deleting of question
	 */
	@Autowired
	public QuestionController(QuestionService questionService, AnswerService answerService, QuestionValidator questionValidator, AnswerValidator answerValidator) {

		this.questionService = questionService;
		this.answerService = answerService;
		this.questionValidator = questionValidator;
		this.answerValidator = answerValidator;
	}

	/**
	 * Send empty questionDTO to view and set value to model
	 *
	 * @param request     - id of test that will have this question
	 * @param questionDTO - DTO of question for model attribute
	 * @param model       - model for session attribute (test id)
	 * @return view for adding question
	 */
	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute("question") QuestionDTO questionDTO, ModelMap model) {
		ModelAndView mav = new ModelAndView("addQuestion");
		long id = Long.parseLong(request.getParameter("testId"));
		model.addAttribute("testId", id);
		mav.addObject("lessonId", questionService.getLessonId(id));
		mav.addObject("question", new QuestionDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	/**
	 * Add question to database
	 *
	 * @param questionDTO - object with question text from view
	 * @param modelMap    - model for session attribute (test id)
	 * @return view for adding question
	 */
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ModelAndView addQuestion(@ModelAttribute("question") QuestionDTO questionDTO, ModelMap modelMap, BindingResult result) {
		long id = (long) modelMap.get("testId");
		ModelAndView mav = new ModelAndView("addQuestion");

		if (questionService.checkQuestionsIsNotFull(id)) {
			questionValidator.validate(questionDTO, result);
			if (result.hasErrors()) {
				mav.addObject("question", new QuestionDTO());
			}
			else {
				mav.addObject("lessonId", questionService.getLessonId(id));
				questionService.addQuestion(questionDTO, id);
			}
			return mav;
		}
		else {
			mav.setView(new RedirectView("/elearning"));
		}
		return mav;
	}

	/**
	 * Delete question from database
	 *
	 * @param id - id of question that will be delete
	 * @return mainpage view
	 */
	@RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteQuestion(@PathVariable("id") final long id) {
		questionService.deleteIfQuestionExist(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	public ModelAndView addAnswer(@ModelAttribute("answer") AnswerDTO answerDTO, HttpServletRequest request, BindingResult result) {

		long testId = Long.parseLong(request.getParameter("testId"));
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning"));

		answerValidator.validate(answerDTO, result);
		if (result.hasErrors()) {
		}
		else {
			answerService.addAnswer(answerDTO, testId);
		}
		return modelAndView;
	}
}
