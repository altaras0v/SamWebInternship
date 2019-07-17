package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO implements Serializable {

	private long id;
	private String name;
	private String description;

	public LessonDTO(long id) {
		this.id = id;
	}

}