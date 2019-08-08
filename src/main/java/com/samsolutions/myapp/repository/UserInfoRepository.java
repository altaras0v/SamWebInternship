package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
}
