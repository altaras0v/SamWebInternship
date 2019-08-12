package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Test;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * repository(CRUD) for test
 */
@Repository
public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
	/**
	 * Get test for this lesson
	 *
	 * @param id - lesson id
	 * @return Test (for this lesson)
	 */
	Test findByLessonId(long id);

	Test findById(long id);
}
