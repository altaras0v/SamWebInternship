package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data transfer object for course
 * For sending object to views
 * Redifined some general methods
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

	/**
	 * Constructor for creating course
	 *
	 * @param name            - name of course
	 * @param description     - description of course
	 * @param fullDescription - full description of course (on specific page)
	 */
	public CourseDTO(String name, String description, String fullDescription)
	{
		this.name = name;
		this.description = description;
		this.fullDescription = fullDescription;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseDTO courseDTO = (CourseDTO) o;
		return id == courseDTO.id && Objects.equals(name, courseDTO.name) && Objects.equals(description, courseDTO.description) && Objects.equals(fullDescription, courseDTO.fullDescription);
	}

	@Override
	public int hashCode()
	{

		return Objects.hash(name, description, fullDescription, id);
	}

	@Override
	public String toString()
	{
		return "CourseDTO{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", fullDescription='" + fullDescription + '\'' + ", id=" + id + '}';
	}
}
