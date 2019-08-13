package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.dto.LessonDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LessonValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {

		LessonDTO lessonDTO = (LessonDTO) o;

		String name = lessonDTO.getName();
		String desc = lessonDTO.getDescription();

		if(name.length()>Integer.parseInt(properties.getProperty("lesson.name.len"))){
			errors.rejectValue("name", "lesson.name");
		}

		if(desc.length()>Integer.parseInt(properties.getProperty("lesson.desc.len"))){
			errors.rejectValue("name", "lesson.desc");
		}

	}
}
