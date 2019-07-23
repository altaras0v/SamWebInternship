package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.TestDTO;
import com.samsolutions.myapp.model.Test;
import org.springframework.stereotype.Service;

/**
 * Service for test
 */
@Service
public interface TestService {
	/**
	 * Get test for this lesson
	 *
	 * @param id - id of lesson
	 * @return TestDTO for view
	 */
	TestDTO getTestByLessonId(long id);

	/**
	 * Add test
	 *
	 * @param test - test entity(name and description)
	 */
	void addTest(Test test);

	/**
	 * Delete test
	 *
	 * @param id - id of test
	 */
	void deleteTest(long id);
}
