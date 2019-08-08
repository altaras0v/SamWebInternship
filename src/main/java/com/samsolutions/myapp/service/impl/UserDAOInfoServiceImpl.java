package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.UserInfo;
import com.samsolutions.myapp.repository.UserInfoRepository;
import com.samsolutions.myapp.service.api.UserDAOInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAOInfoServiceImpl implements UserDAOInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOServiceImpl.class);

	private final UserInfoRepository userInfoRepository;

	@Autowired
	public UserDAOInfoServiceImpl(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	@Override
	public void addInfo(UserInfo userInfo) {
		userInfoRepository.save(userInfo);
		logger.info("addInfo method");
	}
}
