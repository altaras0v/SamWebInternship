package com.samsolutions.myapp.service;

import com.samsolutions.myapp.dto.AnswerDTO;
import com.samsolutions.myapp.model.Answer;
import com.samsolutions.myapp.model.Result;
import com.samsolutions.myapp.model.Test;
import com.samsolutions.myapp.service.api.AnswerDAOService;
import com.samsolutions.myapp.service.api.ResultDAOService;
import com.samsolutions.myapp.service.api.TestService;
import com.samsolutions.myapp.service.api.UserDAOService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnswerService {

	private final AnswerDAOService answerDAOService;

	private final UserDAOService userDAOService;

	private final ResultDAOService resultDAOService;

	private final TestService testService;

	public AnswerService(AnswerDAOService answerDAOService, ResultDAOService resultDAOService, UserDAOService userDAOService, TestService testService) {
		this.answerDAOService = answerDAOService;
		this.resultDAOService = resultDAOService;
		this.userDAOService = userDAOService;
		this.testService = testService;
	}

	public void addAnswer(AnswerDTO answerDTO,long testId){
		User authUser = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		String username = authUser.getUsername();
		com.samsolutions.myapp.model.User user = userDAOService.getUser(username);

		Test test = testService.getTestById(testId);

		Result result = new Result(user,test);
		resultDAOService.addResult(result);
		Answer answer = new Answer(result,answerDTO.getAnswer1(),answerDTO.getAnswer2(),answerDTO.getAnswer3(),
				answerDTO.getAnswer4(),answerDTO.getAnswer5());
		answerDAOService.addAnswer(answer);

	}
}
