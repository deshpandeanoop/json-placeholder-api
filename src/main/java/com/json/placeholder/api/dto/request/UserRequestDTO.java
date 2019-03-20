package com.json.placeholder.api.dto.request;

import java.util.List;

import com.json.placeholder.api.model.User;

public class UserRequestDTO {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
