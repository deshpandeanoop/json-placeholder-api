package com.json.placeholder.api.dto.response;

import java.util.List;

import com.json.placeholder.api.model.Task;

public class TaskResponseDTO extends ResponseDTO{
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
