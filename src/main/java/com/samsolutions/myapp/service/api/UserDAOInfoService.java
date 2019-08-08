package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserDAOInfoService {

	void addInfo(UserInfo info);

}
