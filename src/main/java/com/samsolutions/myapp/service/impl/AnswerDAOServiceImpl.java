package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.Answer;
import com.samsolutions.myapp.repository.AnswerRepository;
import com.samsolutions.myapp.service.api.AnswerDAOService;
import org.springframework.stereotype.Service;

@Service
public class AnswerDAOServiceImpl implements AnswerDAOService {

	private final AnswerRepository answerRepository;

	public AnswerDAOServiceImpl(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	@Override
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}

	@Override
	public Answer getAnswerByResultId(long id) {
		return answerRepository.findByResultId(id);
	}
}
