package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Question;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository(CRUD) for question
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>, JpaSpecificationExecutor<Question> {
	/**
	 * Method that find questions for this test in database
	 *
	 * @param id - id of test
	 * @return list with questions
	 */
	List<Question> findByTestId(long id);
}
