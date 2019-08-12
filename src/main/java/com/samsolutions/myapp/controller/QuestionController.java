package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.AnswerDTO;
import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.service.AnswerService;
import com.samsolutions.myapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	private final QuestionService questionService;
	private final AnswerService answerService;

	/**
	 * Constructor for controller
	 *
	 * @param questionService - service for question, adding,getting and deleting of question
	 */
	@Autowired
	public QuestionController(QuestionService questionService, AnswerService answerService)
	{

		this.questionService = questionService;
		this.answerService = answerService;
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
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute("question") QuestionDTO questionDTO, ModelMap model)
	{
		ModelAndView mav = new ModelAndView("addQuestion");
		long id = Long.parseLong(request.getParameter("testId"));
		model.addAttribute("testId", id);
		mav.addObject("lessonId",questionService.getLessonId(id));
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
	public ModelAndView addQuestion(@ModelAttribute("question") QuestionDTO questionDTO, ModelMap modelMap)
	{
		long id = (long) modelMap.get("testId");
		ModelAndView mav = new ModelAndView("addQuestion");
		mav.addObject("lessonId",questionService.getLessonId(id));
		questionService.addQuestion(questionDTO,id);
		return mav;
	}

	/**
	 * Delete question from database
	 *
	 * @param id - id of question that will be delete
	 * @return mainpage view
	 */
	@RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteQuestion(@PathVariable("id") final long id)
	{
		questionService.deleteQuestion(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	public ModelAndView addAnswer(@ModelAttribute("answer") AnswerDTO answerDTO, HttpServletRequest request) {

		long testId = Long.parseLong(request.getParameter("testId"));
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning"));
		answerService.addAnswer(answerDTO,testId);

		return modelAndView;
	}
}
