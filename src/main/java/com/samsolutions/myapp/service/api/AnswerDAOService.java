package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.Answer;
import org.springframework.stereotype.Service;

@Service
public interface AnswerDAOService {

	void addAnswer(Answer answer);

	Answer getAnswerByResultId(long id);

}
