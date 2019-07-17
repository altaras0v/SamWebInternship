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
public class TestDTO implements Serializable {

	private long id;
	private String name;
	private String description;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TestDTO testDTO = (TestDTO) o;
		return id == testDTO.id && Objects.equals(name, testDTO.name) && Objects.equals(description, testDTO.description);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, description);
	}

	@Override
	public String toString() {
		return "TestDTO{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + '}';
	}
}
