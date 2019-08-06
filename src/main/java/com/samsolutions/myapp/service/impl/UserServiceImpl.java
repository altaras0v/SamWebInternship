package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.repository.UserRepository;
import com.samsolutions.myapp.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//test
	@Override
	public User getUser(String login) {
		User user = userRepository.findByName(login);
		return user;
	}

	@Override
	public void addUser(User user) {
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		logger.info("deleteUser method");
	}

	@Override
	public User getUserById(long id) {
		User user = userRepository.findById(id)
				.get();
		logger.info("getUserById method");
		return user;
	}

	@Override
	public void updateUser(User user) {

		logger.info("updateUser method");
	}

	@Override
	public List<UserDTO> getUsers() {

		/*List<User> users = (List<User>) userRepository.findAll();
		logger.info("getUsers method");
		return users.stream()
				.map(c -> new UserDTO(c.getId(), c.getName(), c.getPassword()))
				.collect(Collectors.toList());*/
		return null;
	}
}
