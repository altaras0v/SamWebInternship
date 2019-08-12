package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

	private final UserService userService;

	@Autowired
	public MainController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView start() {
		ModelAndView modelAndView = new ModelAndView("main");
		modelAndView.addObject("auth",userService.getUserAuth());

		return modelAndView;
	}
}
