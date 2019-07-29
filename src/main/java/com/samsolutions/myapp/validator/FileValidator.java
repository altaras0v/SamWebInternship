package com.samsolutions.myapp.validator;

import com.samsolutions.myapp.config.ApplicationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//ПРОВЕРИТЬ, ЧТО ТАКОЙ ФАЙЛ УЖЕ ЕСТЬ

/**
 * Class-validator for uploading files.
 */
@Component
public class FileValidator implements Validator {

	private ApplicationProperties properties = new ApplicationProperties();
	// valid format for uploading file
	private final List<String> TYPES_OF_FILE = Arrays.asList(properties.getProperty("TYPES_OF_FILE").split(","));
	private final int MAX_SIZE = Integer.parseInt(properties.getProperty("FILE_MAX_SIZE")); // size for medium BLOB format (bytes)
	private final List<String> CONTENT_TYPE_OF_FILE =  Arrays.asList(properties.getProperty("CONTENT_TYPE_OF_FILE").split(","));

	public static Map<String, String> createMapFromLists(List<String> keys, List<String> values) {
		return IntStream.range(0, keys.size()).boxed()
				.collect(Collectors.toMap(keys::get, values::get));
	}

	private final Map<String,String> TYPES_MAP = createMapFromLists(TYPES_OF_FILE,CONTENT_TYPE_OF_FILE);

	@Override
	public boolean supports(Class<?> aClass) {
		return false;
	}

	/**
	 * Parameters validation
	 *
	 * @param o      - file that will be uploaded
	 * @param errors - error if it exist
	 */
	@Override
	public void validate(Object o, Errors errors) {

		UploadedFile file = (UploadedFile) o;
		// Check that size not null
		if (file.getFile().getSize() == 0) {
			errors.rejectValue("file", "uploadForm.selectFile", "Please select a file!");
		} else {

			//Check valid format of file
			String fileExtension = file
					.getFile()
					.getOriginalFilename()
					.substring(file.getFile().getOriginalFilename().lastIndexOf(".") + 1, file.getFile().getOriginalFilename().length());

			if (!TYPES_OF_FILE.contains(fileExtension.toLowerCase())) {
				errors.rejectValue("file", "uploadForm.selectFile", "This file format is not supported!");
				return;
			}

			if(!TYPES_MAP.get(fileExtension).equals(file.getFile().getContentType())){
				errors.rejectValue("file", "uploadForm.selectFile", "Invalid file format!");
				return;
			}

			//Check that file is not too large
			if (file.getFile().getSize() > MAX_SIZE) {
				errors.rejectValue("file", "uploadForm.selectFile", "File size too large! Max size 16 MB");
			}

		}
	}
}