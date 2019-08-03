package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.Role;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.service.impl.RoleServiceImpl;
import com.samsolutions.myapp.service.impl.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

	private final UserServiceImpl userService;
	private final RoleServiceImpl roleService;

	public UserService(UserServiceImpl userService, RoleServiceImpl roleService){
		this.userService = userService;
		this.roleService = roleService;
	}

	public void addUser(UserDTO userDTO){
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(new BCryptPasswordEncoder(12).encode(userDTO.getPassword()));

		Set<Role> userRoles = new HashSet<>();
		List<Role> roles = roleService.getRoles();
		for (Role iter : roles) {
			if (iter.getName().equals("ROLE_USER")) {
				userRoles.add(iter);
			}
		}
		user.setRoles(userRoles);
		userService.addUser(user);
	}

}
