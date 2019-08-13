package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO implements Serializable {

	private long id;
	private int grade;
	private String comments;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultDTO resultDTO = (ResultDTO) o;
		return id == resultDTO.id && grade == resultDTO.grade && Objects.equals(comments, resultDTO.comments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, grade, comments);
	}

	@Override
	public String toString() {
		return "ResultDTO{" + "id=" + id + ", grade=" + grade + ", comments='" + comments + '\'' + '}';
	}
}
