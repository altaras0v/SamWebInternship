package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Component
public class PhotoValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();

	private final List<String> TYPES_OF_PHOTO= Arrays.asList(properties.getProperty("TYPES_OF_PHOTO")
			.split(","));

	private final int MAX_SIZE = Integer.parseInt(properties.getProperty("FILE_MAX_SIZE"));

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {

		MultipartFile file = (MultipartFile) o;


		String fileExtension = file
				.getOriginalFilename()
				.substring(file
						.getOriginalFilename()
						.lastIndexOf(".") + 1, file
						.getOriginalFilename()
						.length());

		if (file.getSize() == 0) {
			errors.rejectValue("photo", "uploadForm.selectFile", "File is empty!");
		}else {

			if (!TYPES_OF_PHOTO.contains(fileExtension.toLowerCase())) {
				errors.rejectValue("photo", "uploadForm.selectFile", "This file format is not supported!");
				return;
			}
			if (file.getSize() > MAX_SIZE) {
				errors.rejectValue("photo", "uploadForm.selectFile", "Photo size too large! Max size 16 MB");
			}
		}

	}

}
