package com.samsolutions.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private long id;
	private String name;
	private String password;
	private String fName;
	private String lName;
	private MultipartFile photo;

	public UserDTO(String name, String password) {
		this.name = name;
		this.password = password;
	}



	@Override
	public String toString() {
		return "UserDTO{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", fName='" + fName + '\'' + ", lName='" + lName + '\'' + ", photo=" + Arrays.toString(new MultipartFile[]{photo}) + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserDTO userDTO = (UserDTO) o;
		return id == userDTO.id && Objects.equals(name, userDTO.name) && Objects.equals(password, userDTO.password) && Objects.equals(fName, userDTO.fName) && Objects.equals(lName, userDTO.lName) && Objects.equals(photo, userDTO.photo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, fName, lName, photo);
	}
}
