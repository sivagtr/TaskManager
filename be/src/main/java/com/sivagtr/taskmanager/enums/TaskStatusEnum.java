package com.sivagtr.taskmanager.enums;

public enum TaskStatusEnum {
	SCHEDULED("scheduled"),
	IN_PROGRESS("in-progress"),
	COMPLETED("completed");

	private String status;
	TaskStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
