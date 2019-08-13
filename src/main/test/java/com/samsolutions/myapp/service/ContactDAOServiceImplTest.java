package com.samsolutions.myapp.service;

import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.model.User;
import com.samsolutions.myapp.repository.ContactRepository;
import com.samsolutions.myapp.service.impl.ContactDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ContactDAOServiceImplTest {

	@Mock
	private ContactRepository contactRepository;

	@InjectMocks
	private ContactDAOServiceImpl contactDAOService;
/*
	public List<C> createCourseList() {
		Course courseOne = new Course();
		courseOne.setName("My Course 1");
		courseOne.setDescription("Desc1");
		courseOne.setFullDescription("FullDesc1");
		Course courseTwo = new Course();
		courseTwo.setName("My Course 2");
		courseTwo.setDescription("Desc2");
		courseTwo.setFullDescription("FullDesc2");
		List<Course> courseList = new ArrayList<>();
		courseList.add(courseOne);
		courseList.add(courseTwo);
		return courseList;
	}*/

	@Test
	public void makeContactShouldCallRepository(){

		User user = new User();

		contactDAOService.makeContact(user,user);

		verify(contactRepository).save(Mockito.any(Contact.class));
	}

	@Test
	public void getAllContactShouldCallRepository(){

		contactDAOService.getAllContact();

		verify(contactRepository).findAll();

	}

	@Test
	public void getCoursesShouldReturnNotNullListWhenRepositoryReturnEmptyCollection() {
		//
		when(contactRepository.findAll()).thenReturn(Collections.emptyList());


		//when
		List<Contact> contactsList = contactDAOService.getAllContact();

		//then
		assertThat(contactsList).isNotNull();
	}

	@Test
	public void getCoursesListShouldReturnEmptyListWhenRepositoryReturnEmptyCollection() {
		//
		when(contactRepository.findAll()).thenReturn(Collections.emptyList());

		//when
		List<Contact> contactsList = contactDAOService.getAllContact();

		//then
		assertThat(contactsList).isEmpty();
	}



}
