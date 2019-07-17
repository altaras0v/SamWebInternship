package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CourseDTO courseDTO = (CourseDTO) o;
		return id == courseDTO.id && Objects.equals(name, courseDTO.name) && Objects.equals(description, courseDTO.description) && Objects.equals(fullDescription, courseDTO.fullDescription);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, description, fullDescription, id);
	}

	@Override
	public String toString() {
		return "CourseDTO{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", fullDescription='" + fullDescription + '\'' + ", id=" + id + '}';
	}
}
