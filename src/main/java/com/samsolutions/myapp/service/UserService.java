package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.Role;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.model.UserInfo;
import com.samsolutions.myapp.service.api.RoleService;
import com.samsolutions.myapp.service.api.UserDAOInfoService;
import com.samsolutions.myapp.service.api.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class UserService {

	private final UserDAOService userDAOService;
	private final RoleService roleService;
	private final UserDAOInfoService userDAOInfoService;

	@Autowired
	public UserService(RoleService roleService, UserDAOInfoService userDAOInfoService, UserDAOService userDAOService) {
		this.roleService = roleService;
		this.userDAOInfoService = userDAOInfoService;
		this.userDAOService = userDAOService;
	}


	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(new BCryptPasswordEncoder(12).encode(userDTO.getPassword()));

		UserInfo userInfo = new UserInfo();
		userInfo.setFName(userDTO.getFName());
		userInfo.setLName(userDTO.getLName());
		try {
			if (userDTO.getPhoto().getSize() != 0) {
				userInfo.setPhoto(userDTO.getPhoto()
						.getBytes());
			}
			else {
				String path = Objects.requireNonNull(getClass().getClassLoader()
						.getResource(""))
						.getPath();
				File defaultAvatar = new File(path+"/user.png");
				byte[] avatarContent = Files.readAllBytes(defaultAvatar.toPath());
				userInfo.setPhoto(avatarContent);


			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		Set<Role> userRoles = new HashSet<>();
		List<Role> roles = roleService.getRoles();
		for (Role iter : roles) {
			if (iter.getName()
					.equals("ROLE_USER")) {
				userRoles.add(iter);
			}
		}
		user.setRoles(userRoles);
		userDAOService.addUser(user);
		userInfo.setUser(user);
		userDAOInfoService.addInfo(userInfo);
	}

}