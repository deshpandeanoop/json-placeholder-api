package com.json.placeholder.api.dto.request;

public class TaskRequestDTO {
	private int userId;
	private int taskId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
}
