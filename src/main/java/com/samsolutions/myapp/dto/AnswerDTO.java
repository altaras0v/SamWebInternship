package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {

	private long id;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;

	@Override
	public String toString() {
		return "AnswerDTO{" + "id=" + id + ", answer1='" + answer1 + '\'' + ", answer2='" + answer2 + '\'' + ", answer3='" + answer3 + '\'' + ", answer4='" + answer4 + '\'' + ", answer5='" + answer5 + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AnswerDTO answerDTO = (AnswerDTO) o;
		return id == answerDTO.id && Objects.equals(answer1, answerDTO.answer1) && Objects.equals(answer2, answerDTO.answer2) && Objects.equals(answer3, answerDTO.answer3) && Objects.equals(answer4, answerDTO.answer4) && Objects.equals(answer5, answerDTO.answer5);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, answer1, answer2, answer3, answer4, answer5);
	}
}
