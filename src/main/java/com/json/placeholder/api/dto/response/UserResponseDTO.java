package com.json.placeholder.api.dto.response;

import java.util.List;

import com.json.placeholder.api.model.User;

public class UserResponseDTO extends ResponseDTO {
	private List<User> users;

	public UserResponseDTO() {
		return;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
