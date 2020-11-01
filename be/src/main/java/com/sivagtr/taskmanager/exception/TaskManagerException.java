package com.sivagtr.taskmanager.exception;

import lombok.Getter;

@Getter
public class TaskManagerException extends Exception {
	private int responseCode = 500;

	public TaskManagerException(int responseCode, String data) {
		super(data);
		this.responseCode = responseCode;
	}

	public TaskManagerException(String data) {
		super(data);
	}
}
