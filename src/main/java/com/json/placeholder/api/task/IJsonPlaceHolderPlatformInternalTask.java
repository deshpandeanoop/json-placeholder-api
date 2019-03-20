package com.json.placeholder.api.task;

import java.util.List;

import com.json.placeholder.api.model.User;

public interface IJsonPlaceHolderPlatformInternalTask {
	public List<User> getUsers();
	public List<User> saveUsers(List<User> users);
}
