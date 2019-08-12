package com.samsolutions.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",  method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@ModelAttribute("value") String string, HttpServletRequest request){
		ModelAndView mnv = new ModelAndView("mainlogin");
		String isError = request.getParameter("error");
		if ("true".equals(isError)) {
			mnv.addObject("errorMessage", "Wrong credentials");
		}
		return mnv;
	}

}
