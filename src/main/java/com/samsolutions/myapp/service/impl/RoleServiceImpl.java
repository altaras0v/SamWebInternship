package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.Role;
import com.samsolutions.myapp.repository.RoleRepository;
import com.samsolutions.myapp.service.api.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}
}
