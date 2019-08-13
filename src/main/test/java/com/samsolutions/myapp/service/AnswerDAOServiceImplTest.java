package com.samsolutions.myapp.service;

import com.samsolutions.myapp.model.Answer;
import com.samsolutions.myapp.repository.AnswerRepository;
import com.samsolutions.myapp.service.impl.AnswerDAOServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AnswerDAOServiceImplTest {

	@Mock
	private AnswerRepository answerRepository;

	@InjectMocks
	private AnswerDAOServiceImpl answerDAOService;

	@Test
	public void addAnswerShouldCallRepository(){

		Answer answer = new Answer();

		answerDAOService.addAnswer(answer);

		verify(answerRepository).save(Mockito.any(Answer.class));

	}

	@Test
	public void addAnswerShouldAddAnswer(){
		Answer answer = new Answer();

		when(answerRepository.save(Mockito.any(Answer.class))).thenReturn(answer);

		answerDAOService.addAnswer(answer);

		verify(answerRepository,times(1)).save(Mockito.any(Answer.class));
	}



}
