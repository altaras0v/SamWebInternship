package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.repository.ContactRepository;
import com.samsolutions.myapp.service.api.ContactDAOService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDAOServiceImpl implements ContactDAOService {

	private final ContactRepository contactRepository;

	public ContactDAOServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public void makeContact(User mentor, User user) {

		Contact contact = new Contact();
		contact.setMentor(mentor);
		contact.setUser(user);
		contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContact() {
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public void deleteContact(Contact contact) {
		contactRepository.delete(contact);
	}

	@Override
	public Contact getContactById(long id) {
		return contactRepository.findById(id).get();
	}

	@Override
	public List<Contact> getContactsByMentorId(long id) {
		return contactRepository.findAllByMentorId(id);
	}
}
