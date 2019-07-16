package myapp.dto;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

	private int id;
	private String question;

	public QuestionDTO() {
	}

	public QuestionDTO(int id, String question) {
		this.id = id;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
