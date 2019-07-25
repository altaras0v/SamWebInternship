package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.User;
import com.samsolutions.myapp.service.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String login) {
		User user = new User();
		user.setLogin(login);
		user.setPassword("admin");

		return user;
	}

}
