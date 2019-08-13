package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.dto.QuestionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
public class QuestionValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {

		QuestionDTO questionDTO = (QuestionDTO) o;

		if(questionDTO.getQuestion().length()>Integer.parseInt(properties.getProperty("question.len"))){
			errors.rejectValue("question", "lesson.name");
		}
		if (isEmpty(questionDTO.getQuestion())){
			errors.rejectValue("question", "lesson.null");
		}

	}
}
