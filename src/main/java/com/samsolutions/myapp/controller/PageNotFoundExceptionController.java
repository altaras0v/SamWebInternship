package com.samsolutions.myapp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Controller for error page
 */
@ControllerAdvice
public class PageNotFoundExceptionController {
	/**
	 * Error page controller
	 *
	 * @param ex - exception
	 * @return - error page
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle(Exception ex)
	{
		// TODO: 23.07.2019 make error jsp 
		return new ModelAndView("test");
	}

}
