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

/**
 * Implementation of {@link TestService}
 */
@Service
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

	private final TestRepository testRepository;

	/**
	 * Constructor with needed repository
	 *
	 * @param testRepository - repository(CRUD) for test
	 */
	@Autowired
	public TestServiceImpl(TestRepository testRepository)
	{
		this.testRepository = testRepository;
	}

	/**
	 * Get test from database for this lesson
	 *
	 * @param id - id of lesson
	 * @return TestDTO for needed course (for view)
	 */
	@Override
	@Transactional
	public TestDTO getTestByLessonId(long id)
	{

		if (testRepository.findByLessonId(id) != null) {
			Test test = testRepository.findByLessonId(id);
			logger.info("getTestByLessonId method");
			return new TestDTO(test.getId(), test.getName(), test.getDescription());
		}
		else {
			return new TestDTO();
		}

	}

	/**
	 * Add test to database
	 * @param test - test entity(name and description)
	 */
	@Override
	public void addTest(Test test)
	{
		testRepository.save(test);
		logger.info("addTest method");
	}

	/**
	 * Delete test from database
	 * @param id - id of test
	 */
	@Override
	public void deleteTest(long id)
	{
		testRepository.deleteById(id);
		logger.info("deleteTest method");
	}

	@Override
	public Test getTestById(long id) {
		return testRepository.findById(id);
	}
}
