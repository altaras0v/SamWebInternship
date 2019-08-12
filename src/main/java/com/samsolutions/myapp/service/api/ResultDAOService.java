package com.samsolutions.myapp.service.api;

import com.samsolutions.myapp.model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultDAOService {

	void addResult(Result result);

	List<Result> getResultsByUserIdAndGrade(long id,int grade);

	Result getResultById(long id);

	List<Result> getResultByUserId(long id);

}
