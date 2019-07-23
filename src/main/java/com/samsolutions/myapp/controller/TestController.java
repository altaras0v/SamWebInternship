package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.dto.TestDTO;
import com.samsolutions.myapp.model.Lesson;
import com.samsolutions.myapp.model.Test;
import com.samsolutions.myapp.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller for test
 * lesson id - id of lesson that have this test
 */
@Controller
@SessionAttributes("lessonId")
public class TestController {


	private final TestService testService;

	/**
	 * Constructor of controller
	 *
	 * @param testService - service of test, get,upload and delete test
	 */
	@Autowired
	public TestController(TestService testService)
	{
		this.testService = testService;
	}

	/**
	 * Send empty testDTO to view and set value to model
	 *
	 * @param request -  id of lesson that will have this test
	 * @param testDTO - DTO of test for model attribute
	 * @param model   - model for session attribute (lesson id)
	 * @return view for adding test
	 */
	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, @ModelAttribute TestDTO testDTO, ModelMap model)
	{
		ModelAndView mav = new ModelAndView("addTest");
		long id = Long.parseLong(request.getParameter("lessonId"));
		model.addAttribute("lessonId", id);
		mav.addObject("test", new TestDTO());
		return mav;
	}

	//СДЕЛАТЬ РЕДИРЕКТ

	/**
	 * Add test to database
	 *
	 * @param testDTO  - object with name and description of test from view
	 * @param modelMap - model for session attribute (lesson id)
	 * @return view for adding test
	 */
	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public ModelAndView AddTest(@ModelAttribute("test") TestDTO testDTO, ModelMap modelMap)
	{
		long id = (long) modelMap.get("lessonId");
		ModelAndView mav = new ModelAndView("addTest");
		Lesson lesson = new Lesson();
		lesson.setId(id);
		testService.addTest(new Test(testDTO.getName(), testDTO.getDescription(), lesson));
		return mav;
	}

	/**
	 * Delete test from database
	 *
	 * @param request - id of test that will be delete
	 * @return mainpage view
	 */
	@RequestMapping(value = "/deleteTest", method = RequestMethod.GET)
	public ModelAndView deleteTest(HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView("mainpage");
		long id = Long.parseLong(request.getParameter("testId"));
		testService.deleteTest(id);
		return mav;
	}
}

