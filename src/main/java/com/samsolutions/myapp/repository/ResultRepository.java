package com.samsolutions.myapp.repository;

import com.samsolutions.myapp.model.Result;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends CrudRepository<Result, Long>, JpaSpecificationExecutor<Result> {

	List<Result> findAllByUserIdAndAndGradeEquals(long id,int grade);

	Result findById(long id);

	List<Result> findAllByUserId(long id);

}
