package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.Role;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.model.UserInfo;
import com.samsolutions.myapp.model.UserRole;
import com.samsolutions.myapp.service.api.RoleService;
import com.samsolutions.myapp.service.api.UserDAOInfoService;
import com.samsolutions.myapp.service.api.UserDAOService;
import com.samsolutions.myapp.service.api.UserRoleDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.stream.Collectors;

@Service
public class UserService {

	private final UserDAOService userDAOService;
	private final RoleService roleService;
	private final UserDAOInfoService userDAOInfoService;
	private final UserRoleDaoService userRoleDaoService;

	@Autowired
	public UserService(RoleService roleService, UserDAOInfoService userDAOInfoService, UserDAOService userDAOService, UserRoleDaoService userRoleDaoService) {
		this.roleService = roleService;
		this.userDAOInfoService = userDAOInfoService;
		this.userDAOService = userDAOService;
		this.userRoleDaoService = userRoleDaoService;
	}

	@Transactional
	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setPassword(new BCryptPasswordEncoder(12).encode(userDTO.getPassword()));

		UserInfo userInfo = new UserInfo();
		userInfo.setFName(userDTO.getFName());
		userInfo.setLName(userDTO.getLName());
		try {
			if (userDTO.getPhoto()
					.getSize() != 0) {
				userInfo.setPhoto(userDTO.getPhoto()
						.getBytes());
			}
			else {
				String path = Objects.requireNonNull(getClass().getClassLoader()
						.getResource(""))
						.getPath();
				File defaultAvatar = new File(path + "/user.png");
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

	public Authentication getUserAuth() {
		return SecurityContextHolder.getContext()
				.getAuthentication();
	}

	public List<UserDTO> getUsersForAdmin(long id) {

		List<UserRole> userRoles = userRoleDaoService.getUserRolesByRoleId(id);

		List<UserDTO> userDTOList = userRoles.stream()
				.map(c -> new UserDTO(userDAOService.getUserById(c.getUser().getId())
						.getId(), userDAOService.getUserById(c.getUser().getId())
						.getName(), userDAOService.getUserById(c.getUser().getId())
						.getPassword(), userDAOInfoService.getInfoByUserId(c.getUser().getId()).getFName(),
						userDAOInfoService.getInfoByUserId(c.getUser().getId()).getLName(),
						userDAOInfoService.getInfoByUserId(c.getUser().getId()).getPhoto(),
						getUserRoleByUserId(c.getUser().getId()).getRole().getName())).collect(Collectors.toList());

				return userDTOList;

	}

	public UserRole getUserRoleByUserId(long id){

		UserRole userRole = userRoleDaoService.getUserRoleByUserId(id);

		return userRole;
	}
}