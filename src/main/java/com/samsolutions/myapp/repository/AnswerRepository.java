package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Answer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository  extends CrudRepository<Answer, Long>, JpaSpecificationExecutor<Answer> {

	Answer findByResultId(long id);

}
