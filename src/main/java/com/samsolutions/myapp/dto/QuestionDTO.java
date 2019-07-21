package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

/**
 * Data transfer object for question
 * For sending object to views
 * Redifined some general methods
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO implements Serializable {

	private long id;
	private String question;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		QuestionDTO that = (QuestionDTO) o;
		return id == that.id && Objects.equals(question, that.question);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, question);
	}

	@Override
	public String toString() {
		return "QuestionDTO{" + "id=" + id + ", question='" + question + '\'' + '}';
	}
}
