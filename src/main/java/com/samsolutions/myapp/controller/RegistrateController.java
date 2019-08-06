package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrateController {

	private final UserService userService;

	@Autowired
	public RegistrateController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView showRegister()
	{
		ModelAndView mav = new ModelAndView("registrationPage");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addCourse(@ModelAttribute("user") UserDTO userDTO)
	{
		ModelAndView mav = new ModelAndView("registrationPage");
		userService.addUser(userDTO);
		System.out.println("GOOD");

		return mav;
	}
}
