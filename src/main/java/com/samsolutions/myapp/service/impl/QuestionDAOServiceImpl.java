package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import com.samsolutions.myapp.repository.QuestionRepository;
import com.samsolutions.myapp.service.api.QuestionDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link QuestionDAOService}
 */
@Service
public class QuestionDAOServiceImpl implements QuestionDAOService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionDAOServiceImpl.class);

	private final QuestionRepository questionRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param questionRepository - repository(CRUD) for question
	 */
	@Autowired
	public QuestionDAOServiceImpl(QuestionRepository questionRepository)
	{
		this.questionRepository = questionRepository;
	}

	/**
	 * Get question from database for this test
	 *
	 * @param id - test id
	 * @return list with question DTOs for needed test (for view)
	 */
	@Override
	public List<QuestionDTO> getQuestionsByTestId(long id)
	{
		if (questionRepository.findByTestId(id) != null) {
			List<Question> questionList = questionRepository.findByTestId(id);
			logger.info("getQuestionByTestId method");
			return questionList.stream()
					.map(c -> new QuestionDTO(c.getId(), c.getQuestion()))
					.collect(Collectors.toList());
		}
		else {
			return Collections.emptyList();
		}

	}

	/**
	 * Add question to database
	 *
	 * @param question - text of question
	 */
	@Override
	public void addQuestion(Question question)
	{
		questionRepository.save(question);
		logger.info("addQuestion method");
	}

	/**
	 * Delete question from database
	 *
	 * @param id - id of question
	 */
	@Override
	public void deleteQuestion(long id)
	{
		questionRepository.deleteById(id);
		logger.info("deleteQuestion method");
	}

	@Override
	public List<Long> getQuestionsId() {
		List<Long> questionsId = new ArrayList<>();
		questionRepository.findAll().forEach(lesson -> questionsId.add(lesson.getId()));
		return questionsId;
	}
}
