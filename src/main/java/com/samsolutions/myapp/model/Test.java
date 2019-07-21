package com.samsolutions.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
/**
 * Entity for test
 */
public class Test implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;

	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> questions = new ArrayList<>();

	/**
	 * Constructor for creating test
	 * @param name - name of test
	 * @param description - description of test
	 * @param lesson - lesson for this test (use only for assignment test to lesson)
	 */
	public Test(String name, String description, Lesson lesson) {
		this.name = name;
		this.description = description;
		this.lesson = lesson;
	}
}
