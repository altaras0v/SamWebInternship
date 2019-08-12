package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactDAOService {
	void makeContact(User mentor, User user);

	List<Contact> getAllContact();

	void deleteContact(Contact contact);

	Contact getContactById(long id);

}
