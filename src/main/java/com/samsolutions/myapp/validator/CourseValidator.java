package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.dto.CourseDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
public class CourseValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {

		CourseDTO courseDTO = (CourseDTO) o;


		if(courseDTO.getName().length()>Integer.parseInt(properties.getProperty("course.name.len"))){
			errors.rejectValue("name", "lesson.name");
		}

		if(courseDTO.getDescription().length()>Integer.parseInt(properties.getProperty("course.desc.len"))){
			errors.rejectValue("description", "lesson.desc");
		}
		if(courseDTO.getFullDescription().length()>Integer.parseInt(properties.getProperty("lesson.desc.len"))){
			errors.rejectValue("description", "lesson.desc");
		}
		if (isEmpty(courseDTO.getName())){
			errors.rejectValue("name", "lesson.null");
		}


	}
}
