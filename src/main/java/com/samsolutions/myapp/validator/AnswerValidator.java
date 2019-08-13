package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.dto.AnswerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class AnswerValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {
		AnswerDTO answerDTO = (AnswerDTO) o;

		if(answerDTO.getAnswer1().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("answer", "lesson.name");
		}
		if(answerDTO.getAnswer2().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("answer", "lesson.name");
		}
		if(answerDTO.getAnswer3().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("answer", "lesson.name");
		}
		if(answerDTO.getAnswer4().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("answer", "lesson.name");
		}
		if(answerDTO.getAnswer5().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("answer", "lesson.name");
		}

	}
}
