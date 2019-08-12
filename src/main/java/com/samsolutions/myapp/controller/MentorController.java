package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MentorController {

	private final MentorService mentorService;

	public MentorController(MentorService mentorService) {
		this.mentorService = mentorService;
	}

	@RequestMapping(value = "/mentor", method = RequestMethod.GET)
	public ModelAndView getMentorPage()
	{
		return mentorService.getMentorPage("mentorpage");

	}

	@RequestMapping(value = "/grade", method = RequestMethod.POST)
	public ModelAndView makeGrade(HttpServletRequest request)
	{
		String grade = request.getParameter("grade");

		return mentorService.makeGrade(grade);

	}
}
