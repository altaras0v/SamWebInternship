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
public class RoleDTO implements Serializable {

	private long id;
	private String name;

	public RoleDTO(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RoleDTO roleDTO = (RoleDTO) o;
		return id == roleDTO.id && Objects.equals(name, roleDTO.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "RoleDTO{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
