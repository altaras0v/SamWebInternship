package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.dto.TestDTO;
import com.samsolutions.myapp.model.Test;
import com.samsolutions.myapp.repository.TestRepository;
import com.samsolutions.myapp.service.api.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	private final TestRepository testRepository;

	@Autowired
	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	@Transactional
	public TestDTO getTestByLessonId(long id) {

		if (testRepository.findByLessonId(id) != null) {
			Test test = testRepository.findByLessonId(id);
			logger.info("getTestByLessonId method");
			return new TestDTO(test.getId(),test.getName(), test.getDescription());
		}
		else {
			return new TestDTO();
		}

	}

	@Override
	public void addTest(Test test)
	{
		testRepository.save(test);
		logger.info("addTest method");
	}

	@Override
	public void deleteTest(long id)
	{
		testRepository.delete(id);
		logger.info("deleteTest method");
	}
}
