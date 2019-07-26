package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
