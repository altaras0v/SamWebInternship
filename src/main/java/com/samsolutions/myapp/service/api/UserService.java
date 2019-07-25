package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	User getUser(String login);

}
