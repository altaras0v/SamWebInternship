package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public interface QuestionDAOService {
	/**
	 * Get questions for this test
	 *
	 * @param id - test id
	 * @return list with questions
	 */
	List<QuestionDTO> getQuestionsByTestId(long id);

	/**
	 * Add question
	 *
	 * @param question - text of question
	 */
	void addQuestion(Question question);

	/**
	 * delete question
	 *
	 * @param id - id of question
	 */
	void deleteQuestion(long id);
}
