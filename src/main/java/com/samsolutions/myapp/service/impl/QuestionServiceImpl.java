package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.QuestionDTO;
import com.samsolutions.myapp.model.Question;
import com.samsolutions.myapp.repository.QuestionRepository;
import com.samsolutions.myapp.service.api.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	private final QuestionRepository questionRepository;

	@Autowired
	public QuestionServiceImpl(QuestionRepository questionRepository)
	{
		this.questionRepository = questionRepository;
	}


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

	@Override
	public void addQuestion(Question question)
	{
		questionRepository.save(question);
		logger.info("addQuestion method");
	}

	@Override
	public void deleteQuestion(long id)
	{
		questionRepository.delete(id);
		logger.info("deleteQuestion method");
	}
}
