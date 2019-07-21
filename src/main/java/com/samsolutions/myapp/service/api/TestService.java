package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.dto.TestDTO;
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
}
