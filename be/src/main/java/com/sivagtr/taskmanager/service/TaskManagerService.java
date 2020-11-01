package com.sivagtr.taskmanager.service;

import java.util.List;

import com.sivagtr.taskmanager.data.TaskManagerData;
import com.sivagtr.taskmanager.exception.TaskManagerException;

public interface TaskManagerService{

	/**
	 * This is to create a Task
	 * @param taskManagerData
	 * @return
	 */
	void createTask(TaskManagerData taskManagerData) throws TaskManagerException;

	TaskManagerData getTaskById(String id);

	List<TaskManagerData> getAllTasks();

	void deleteTask(String id);

	void deleteAllTask();
}