package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleDaoService {

	List<UserRole> getUserRolesByRoleId(long id);

	UserRole getUserRoleByUserId(long id);

	void updateRole(UserRole userRole);
}
