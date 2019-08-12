package com.samsolutions.myapp.service.impl;

import com.samsolutions.myapp.model.Result;
import com.samsolutions.myapp.repository.ResultRepository;
import com.samsolutions.myapp.service.api.ResultDAOService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultDAOServiceImpl implements ResultDAOService {

	private final ResultRepository resultRepository;

	public ResultDAOServiceImpl(ResultRepository resultRepository) {
		this.resultRepository = resultRepository;
	}

	@Override
	public void addResult(Result result) {
		resultRepository.save(result);
	}

	@Override
	public List<Result> getResultsByUserIdAndGrade(long id, int grade) {
		return resultRepository.findAllByUserIdAndAndGradeEquals(id,grade);
	}

	@Override
	public Result getResultById(long id) {
		return resultRepository.findById(id);
	}

	@Override
	public List<Result> getResultByUserId(long id) {
		return resultRepository.findAllByUserId(id);
	}
}
