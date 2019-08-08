package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDAOService {

	User getUser(String login);

	void addUser(User user);

	void deleteUser(long id);

	User getUserById(long id);

	void updateUser(User user);

	User getUserByName(String login);

	List<UserDTO> getUsers();

}
