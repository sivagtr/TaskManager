package com.sivagtr.taskmanager.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivagtr.taskmanager.data.TaskManagerData;
import com.sivagtr.taskmanager.enums.TaskStatusEnum;
import com.sivagtr.taskmanager.exception.TaskManagerException;
import com.sivagtr.taskmanager.store.TaskManagerRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	TaskManagerRepository taskManagerRepository;

	/**
	 * This is to create a Task
	 *
	 * @param taskManagerData
	 * @return
	 */
	@Override
	public void createTask(TaskManagerData taskManagerData) throws TaskManagerException {
		if(isValid(taskManagerData)){
			taskManagerData.setId(UUID.randomUUID().toString());
			taskManagerData.setCreatedDate(new Date());
			taskManagerRepository.save(taskManagerData);
		}else{
			throw new TaskManagerException("Invalid Data");
		}
	}

	private boolean isValid(TaskManagerData taskManagerData) {
		if(taskManagerData.getTitle() == null || taskManagerData.getStatus() == null || Arrays.stream(TaskStatusEnum.values()).filter(taskStatusEnum -> taskStatusEnum.getStatus().contains(taskManagerData.getStatus())).findFirst().orElse(null) == null){
			return false;
		}
		return true;
	}

	@Override
	public TaskManagerData getTaskById(String id) {
		Optional<TaskManagerData> taskManagerData = taskManagerRepository.findById(id);
		return taskManagerData.orElse(null);
	}

	@Override
	public List<TaskManagerData> getAllTasks() {
		List<TaskManagerData> all = taskManagerRepository.findAll();
		return all;
	}

	@Override
	public void deleteTask(String id) {
		taskManagerRepository.deleteById(id);

	}

	@Override
	public void deleteAllTask() {
		taskManagerRepository.deleteAll();
	}
}
