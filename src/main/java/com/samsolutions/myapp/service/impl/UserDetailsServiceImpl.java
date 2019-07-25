package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.User;
import com.samsolutions.myapp.UserRoleEnum;
import com.samsolutions.myapp.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private  UserService userService;

	public UserDetailsServiceImpl() {
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// с помощью нашего сервиса UserService получаем User
		User user = userService.getUser("colibri");
		// указываем роли для этого пользователя
		HashSet roles = new HashSet();
		roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

		// на основании полученных данных формируем объект UserDetails
		// который позволит проверить введенный пользователем логин и пароль
		// и уже потом аутентифицировать пользователя

		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
	}
}
