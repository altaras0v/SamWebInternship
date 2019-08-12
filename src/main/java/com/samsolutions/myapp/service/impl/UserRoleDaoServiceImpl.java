package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.UserRole;
import com.samsolutions.myapp.repository.UserRolesRepository;
import com.samsolutions.myapp.service.api.UserRoleDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleDaoServiceImpl implements UserRoleDaoService {

	private final UserRolesRepository userRolesRepository;

	@Autowired
	public UserRoleDaoServiceImpl(UserRolesRepository userRolesRepository) {
		this.userRolesRepository = userRolesRepository;
	}


	@Override
	public List<UserRole> getUserRolesByRoleId(long id) {

		return userRolesRepository.findAllByRoleId(id);

	}

	@Override
	public UserRole getUserRoleByUserId(long id) {

		return userRolesRepository.findUserRoleByUserId(id);
	}

	@Override
	public void updateRole(UserRole userRole) {
		userRolesRepository.save(userRole);
	}
}
