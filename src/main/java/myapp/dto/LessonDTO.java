package myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO implements Serializable {
	private int id;
	private String name;
	private String description;

	public LessonDTO(int id) {
		this.id = id;
	}

}