package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import com.samsolutions.myapp.dto.UserDTO;
import com.samsolutions.myapp.service.api.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
public class UserValidator implements Validator {

	private final UserDAOService userDAOService;
	private ApplicationProperties properties = new ApplicationProperties();
	private final List<String> TYPES_OF_PHOTO = Arrays.asList(properties.getProperty("TYPES_OF_PHOTO")
			.split(","));
	private final int MAX_SIZE = Integer.parseInt(properties.getProperty("FILE_MAX_SIZE"));

	@Autowired
	public UserValidator(UserDAOService userDAOService) {
		this.userDAOService = userDAOService;
	}

	@Override
	public boolean supports(final Class<?> aClass) {
		return false;
	}

	@Override
	public void validate(final Object o, final Errors errors) {
		UserDTO user = (UserDTO) o;

		MultipartFile file = user.getPhoto();

		String fileExtension = file.getOriginalFilename()
				.substring(file.getOriginalFilename()
						.lastIndexOf(".") + 1, file.getOriginalFilename()
						.length());


		if (isEmpty(user.getName())) {
			errors.rejectValue("name", "registration.error.login.required");
		}
		if (isEmpty(user.getPassword())) {
			errors.rejectValue("password", "registration.error.password.required");
		}
		if (user.getName()
				.length() > Integer.parseInt(properties.getProperty("MAX_LENGTH"))) {
			errors.rejectValue("password", "registration.error.password.weakPassword");
		}
		if (user.getPassword()
				.length() > Integer.parseInt(properties.getProperty("MAX_LENGTH"))) {
			errors.rejectValue("password", "registration.error.login.length");
		}
		if (!Pattern.matches(properties.getProperty("VALID_PASSWORD.regexp"), user.getPassword())) {
			errors.rejectValue("password", "registration.error.password.length");
		}
		if (userDAOService.getUserByName(user.getName()) != null) {
			errors.rejectValue("name", "registration.error.login.exists");
		}
		if (file.getSize() == 0) {
			errors.rejectValue("photo", "registration.error.photo.empty");
		}

		if (!TYPES_OF_PHOTO.contains(fileExtension.toLowerCase())) {
			errors.rejectValue("photo", "registration.error.photo.format");
			return;
		}
		if (file.getSize() > MAX_SIZE) {
			errors.rejectValue("photo", "registration.error.photo.size");
		}

	}
}
