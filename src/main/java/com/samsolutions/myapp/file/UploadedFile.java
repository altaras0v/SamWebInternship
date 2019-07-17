package com.samsolutions.myapp.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * File that will be upload
 * Type - MultipartFile
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UploadedFile {

	private String description;
	private MultipartFile file;

}
