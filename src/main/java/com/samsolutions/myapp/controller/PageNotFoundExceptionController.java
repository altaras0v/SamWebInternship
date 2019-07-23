package com.samsolutions.myapp.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class PageNotFoundExceptionController {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle(Exception ex)
	{
		// TODO: 23.07.2019 make error jsp 
		return new ModelAndView("test");
	}

}
