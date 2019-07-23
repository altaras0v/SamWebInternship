package com.samsolutions.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Entity for question
 * Connected with Test (many question for one test)
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "question")
	private String question;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_id")
	private Test test;

	/**
	 * Constructor for adding question
	 *
	 * @param question - text of question
	 * @param test     - test for this file (use only for assignment question to test)
	 */
	public Question(String question, Test test)
	{
		this.question = question;
		this.test = test;
	}
}
