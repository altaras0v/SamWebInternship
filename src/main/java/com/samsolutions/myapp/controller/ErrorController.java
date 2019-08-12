package com.samsolutions.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Controller for error page
 */
@ControllerAdvice
public class ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	/**
	 * Error page controller
	 *
	 * @param ex - exception
	 * @return - error page
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle(Exception ex) {
		logger.info("Redirect to error page");
		return new ModelAndView("errorPage");
	}


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ModelAndView notFoundHandler() {
		logger.info("Redirect to error page");
		return new ModelAndView("errorPage");
	}

}


