package com.samsolutions.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "result_id")
	private Result result;

	@JoinColumn(name = "answer_1")
	private String answer_1;

	@JoinColumn(name = "answer_2")
	private String answer_2;

	@JoinColumn(name = "answer_3")
	private String answer_3;

	@JoinColumn(name = "answer_4")
	private String answer_4;

	@JoinColumn(name = "answer_5")
	private String answer_5;

	public Answer(Result result, String answer_1, String answer_2, String answer_3, String answer_4, String answer_5) {
		this.result = result;
		this.answer_1 = answer_1;
		this.answer_2 = answer_2;
		this.answer_3 = answer_3;
		this.answer_4 = answer_4;
		this.answer_5 = answer_5;
	}
}
