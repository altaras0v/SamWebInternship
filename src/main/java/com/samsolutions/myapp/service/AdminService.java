package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.model.Role;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.model.UserRole;
import com.samsolutions.myapp.service.api.ContactDAOService;
import com.samsolutions.myapp.service.api.UserRoleDaoService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {


	private final UserService userService;
	private final UserRoleDaoService userRoleDaoService;
	private final ContactDAOService contactDAOService;

	@Autowired
	public AdminService(UserService userService, UserRoleDaoService userRoleDaoService, ContactDAOService contactDAOService) {
		this.userService = userService;
		this.userRoleDaoService = userRoleDaoService;
		this.contactDAOService = contactDAOService;
	}

	public ModelAndView getInfoForAdmin(String name) {
		List<UserDTO> users = userService.getUsersForAdmin(2);
		List<UserDTO> mentors = userService.getUsersForAdmin(3);
		users.addAll(mentors);
		List<Contact> contacts = contactDAOService.getAllContact();
		List<UserDTO> userDTOS = contacts.stream()
				.map(c -> new UserDTO(c.getUser()
						.getId(), c.getUser().getName()))
				.collect(Collectors.toList());
		List<UserDTO> userDTOS1 = users.stream().map(c-> new UserDTO(c.getId(),c.getName())).collect(Collectors.toList());
		List<UserDTO> mentorDTOs = mentors.stream().map(c-> new UserDTO(c.getId(),c.getName())).collect(Collectors.toList());


		List<UserDTO> usersWithoutMentors = (List<UserDTO>) CollectionUtils.disjunction(userDTOS,mentorDTOs);
		List<UserDTO> freeUsers = (List<UserDTO>) CollectionUtils.disjunction(usersWithoutMentors,userDTOS1);
		ModelAndView modelAndView = new ModelAndView(name);
		modelAndView.addObject("auth",userService.getUserAuth());
		modelAndView.addObject("users",users);
		modelAndView.addObject("mentors", mentors);
		modelAndView.addObject("freeUsers",freeUsers);
		modelAndView.addObject("contacts",contacts);
		return modelAndView;
	}

	public void makeMentor(long id) {

		UserRole userRole = userRoleDaoService.getUserRoleByUserId(id);
		Role role = new Role();
		role.setId(3);
		userRole.setRole(role);
		userRoleDaoService.updateRole(userRole);
	}

	public void makeUser(long id) {

		UserRole userRole = userRoleDaoService.getUserRoleByUserId(id);
		Role role = new Role();
		role.setId(2);
		userRole.setRole(role);
		userRoleDaoService.updateRole(userRole);
	}


	public void makeContact(long mentorId, long userId) {
		User mentor = new User();
		mentor.setId(mentorId);
		User user = new User();
		user.setId(userId);
		contactDAOService.makeContact(mentor, user);
	}

	private List<UserDTO> getFreeUsers(List<Contact> contacts,List<UserDTO> users,List<UserDTO> mentors){
		List<UserDTO> userDTOS = contacts.stream()
				.map(c -> new UserDTO(c.getUser()
						.getId(), c.getUser().getName()))
				.collect(Collectors.toList());
		List<UserDTO> userDTOS1 = users.stream().map(c-> new UserDTO(c.getId(),c.getName())).collect(Collectors.toList());
		List<UserDTO> mentorDTOs = mentors.stream().map(c-> new UserDTO(c.getId(),c.getName())).collect(Collectors.toList());


		List<UserDTO> usersWithoutMentors = (List<UserDTO>) CollectionUtils.disjunction(userDTOS,mentorDTOs);
		List<UserDTO> freeUsers = (List<UserDTO>) CollectionUtils.disjunction(usersWithoutMentors,userDTOS1);
		return freeUsers;
	}

	public void deleteContact(long id){
		contactDAOService.deleteContact(contactDAOService.getContactById(id));
	}

}
