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

	@JoinColumn(name = "answer1")
	private String answer1;

	@JoinColumn(name = "answer2")
	private String answer2;

	@JoinColumn(name = "answer3")
	private String answer3;

	@JoinColumn(name = "answer4")
	private String answer4;

	@JoinColumn(name = "answer5")
	private String answer5;


}
