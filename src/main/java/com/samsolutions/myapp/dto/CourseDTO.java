package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Course data transfer object
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO implements Serializable {

	private String name;
	private String description;
	private String fullDescription;
	private long id;

	public CourseDTO(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
}
