package com.samsolutions.myapp.service;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.model.Answer;
import com.samsolutions.myapp.model.Contact;
import com.samsolutions.myapp.model.Result;
import com.samsolutions.myapp.service.api.AnswerDAOService;
import com.samsolutions.myapp.service.api.ContactDAOService;
import com.samsolutions.myapp.service.api.ResultDAOService;
import com.samsolutions.myapp.service.api.UserDAOService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MentorService {

	private final UserDAOService userDAOService;
	private final ContactDAOService contactDAOService;
	private final ResultDAOService resultDAOService;
	private final AnswerDAOService answerDAOService;
	private ApplicationProperties properties = new ApplicationProperties();


	public MentorService(UserDAOService userDAOService, ContactDAOService contactDAOService, ResultDAOService resultDAOService, AnswerDAOService answerDAOService) {
		this.userDAOService = userDAOService;
		this.contactDAOService = contactDAOService;
		this.resultDAOService = resultDAOService;
		this.answerDAOService = answerDAOService;
	}

	public ModelAndView getMentorPage(String page) {
		ModelAndView modelAndView = new ModelAndView(page);

		User authUser = (User) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();

		String username = authUser.getUsername();
		com.samsolutions.myapp.model.User user = userDAOService.getUser(username);
		List<Contact> contacts = contactDAOService.getContactsByMentorId(user.getId());

		List<Long> usersId = contacts.stream()
				.map(c -> c.getUser()
						.getId())
				.collect(Collectors.toList());
		List<Result> results = new ArrayList<>();
		for (long id : usersId) {
			results.addAll(resultDAOService.getResultsByUserIdAndGrade(id, 0));
		}
		List<Long> resultsId = results.stream()
				.map(c -> c.getId())
				.collect(Collectors.toList());

		List<Answer> answerList = new ArrayList<>();
		for (long id : resultsId) {
			answerList.add(answerDAOService.getAnswerByResultId(id));
		}

		modelAndView.addObject("resultsForThisMentor", results);
		modelAndView.addObject("answers", answerList);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	public ModelAndView makeGrade(String grade) {
		ModelAndView mav = new ModelAndView(new RedirectView("/elearning/mentor"));

		List<Integer> res = new ArrayList<>();
		for (String retval : grade.split("/", 2)) {
			res.add(Integer.parseInt(retval));
		}

		Result result = resultDAOService.getResultById(res.get(1));
		if (res.get(0) >= Integer.parseInt(properties.getProperty("grade.min")) || res.get(0) <= Integer.parseInt(properties.getProperty("grade.max"))) {
			result.setGrade(res.get(0));
		}
		resultDAOService.addResult(result);

		return mav;
	}

}
