package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.UserRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long>,
		JpaSpecificationExecutor<UserRole> {

	List<UserRole> findAllByRoleId(long id);
	UserRole findUserRoleByUserId(long id);

}
