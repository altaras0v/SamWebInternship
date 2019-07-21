package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Data transfer object for lesson
 * For sending object to views
 * Redifined some general methods
 */
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LessonDTO lessonDTO = (LessonDTO) o;
		return id == lessonDTO.id && Objects.equals(name, lessonDTO.name) && Objects.equals(description, lessonDTO.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, description);
	}

	@Override
	public String toString() {
		return "LessonDTO{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
	}
}