package com.json.placeholder.api.dto.response;

import java.util.List;

import com.json.placeholder.api.model.Task;
import com.json.placeholder.api.model.Temp1;

public class TaskResponseDTO extends ResponseDTO{
	private List<Task> tasks;
	private List<Temp1> temp;

	
	public List<Temp1> getTemp() {
		return temp;
	}

	public void setTemp(List<Temp1> temp) {
		this.temp = temp;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
