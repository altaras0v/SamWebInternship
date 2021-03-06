package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.service.UserService;
import com.samsolutions.myapp.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrateController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrateController.class);

	private final UserService userService;
	private final UserValidator userValidator;

	@Autowired
	public RegistrateController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		ModelAndView mav = new ModelAndView("registrationPage");
		mav.addObject("user", new UserDTO());
		return mav;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") UserDTO userDTO, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		userValidator.validate(userDTO,result);
		if (result.hasErrors()) {
			logger.info("user validate method error so" + result);
			mav.addObject("user",userDTO);
			mav.setViewName("registrationPage");
		}
		else {
			userService.addUser(userDTO);

			mav.setView(new RedirectView("/elearning"));
		}
		return mav;


	}
}
