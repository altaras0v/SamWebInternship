package com.samsolutions.myapp.controller;

import com.samsolutions.myapp.service.AdminService;
import com.samsolutions.myapp.service.UserService;
import com.samsolutions.myapp.service.api.ContactDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

	private final AdminService adminService;
	private final UserService userService;

	private final ContactDAOService contactDAOService;

	@Autowired
	public AdminController(AdminService adminService, UserService userService, ContactDAOService contactDAOService) {
		this.adminService = adminService;
		this.userService = userService;
		this.contactDAOService = contactDAOService;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView getAdminPage()
	{
		return adminService.getInfoForAdmin("adminpage");
	}

	@RequestMapping(value = "/makeMentor", method = RequestMethod.GET)
	public ModelAndView makeMentor(HttpServletResponse response, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning/admin"));
		long id = Long.parseLong(request.getParameter("id"));
		adminService.makeMentor(id);
		return modelAndView;
	}

	@RequestMapping(value = "/makeUser", method = RequestMethod.GET)
	public ModelAndView makeUser(HttpServletResponse response, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning/admin"));
		long id = Long.parseLong(request.getParameter("id"));
		adminService.makeUser(id);
		return modelAndView;
	}

	@RequestMapping(value = "/makeContact", method = RequestMethod.POST)
	public ModelAndView makeContact(HttpServletResponse response, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning/admin"));
		long mentorId = Long.parseLong(request.getParameter("mentorId"));
		long userId = Long.parseLong(request.getParameter("userId"));

		adminService.makeContact(mentorId,userId);

		return modelAndView;
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public ModelAndView deleteContact(HttpServletResponse response, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/elearning/admin"));
		long contactId = Long.parseLong(request.getParameter("contactId"));


		adminService.deleteContact(contactId);

		return modelAndView;
	}

}
