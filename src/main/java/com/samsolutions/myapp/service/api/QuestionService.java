package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
	List<QuestionDTO> getQuestionsByTestId(long id);

	void addQuestion(Question question);

	void deleteQuestion(long id);
}
