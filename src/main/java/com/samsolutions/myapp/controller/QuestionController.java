package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import com.samsolutions.myapp.model.Test;
import com.samsolutions.myapp.service.api.QuestionService;
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
public class QuestionController {

	private final QuestionService questionService;

	@Autowired
	public QuestionController(QuestionService questionService)
	{
		this.questionService = questionService;
	}

	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute("question") QuestionDTO questionDTO, ModelMap model)
	{
		ModelAndView mav = new ModelAndView("addQuestion");
		long id = Long.parseLong(request.getParameter("testId"));
		model.addAttribute("testId", id);
		mav.addObject("question", new QuestionDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ModelAndView AddQuestion(@ModelAttribute("question") QuestionDTO questionDTO, ModelMap modelMap)
	{
		long id = (long) modelMap.get("testId");
		ModelAndView mav = new ModelAndView("addQuestion");
		Test test = new Test();
		test.setId(id);
		questionService.addQuestion(new Question(questionDTO.getQuestion(),test));
		return mav;
	}

	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
	public ModelAndView deleteQuestion(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("mainpage");
		long id = Long.parseLong(request.getParameter("questionId"));
		System.out.println(id);
		questionService.deleteQuestion(id);
		return mav;
	}
}
