package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

	List<Role> getRoles();

}
