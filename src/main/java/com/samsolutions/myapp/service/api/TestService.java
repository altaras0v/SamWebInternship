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
	 *
	 * @param id
	 * @return
	 */
	TestDTO getTestByLessonId(long id);

	void addTest(Test test);

	void deleteTest(long id);
}
