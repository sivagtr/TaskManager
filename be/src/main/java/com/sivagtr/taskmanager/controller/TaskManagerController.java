package com.sivagtr.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivagtr.taskmanager.ResponseData;
import com.sivagtr.taskmanager.data.TaskManagerData;
import com.sivagtr.taskmanager.exception.TaskManagerException;
import com.sivagtr.taskmanager.service.TaskManagerService;
import com.sivagtr.taskmanager.util.TaskManagerConstants;

@RestController
@RequestMapping(TaskManagerConstants.API_VERSION_V1)
public class TaskManagerController {

	@Autowired
	TaskManagerService taskManagerService;

	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseData> createTask(@RequestBody TaskManagerData taskManagerData) {
		try {
			taskManagerService.createTask(taskManagerData);
		} catch(TaskManagerException e) {
			return ResponseEntity.status(e.getResponseCode()).body(new ResponseData().setError(e.getMessage()));
		}
		return ResponseEntity.ok(new ResponseData().setComments(TaskManagerConstants.CREATED_MSG));
	}

	@GetMapping(value = "/task/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskManagerData> getTaskById(@PathVariable String id) {
		TaskManagerData taskById = taskManagerService.getTaskById(id);
		return ResponseEntity.ok(taskById);
	}

	@GetMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TaskManagerData>> getAllTasks() {
		List<TaskManagerData> allTasks = taskManagerService.getAllTasks();
		return ResponseEntity.ok(allTasks);
	}

	@DeleteMapping(value = "/task/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable String id) {
		taskManagerService.deleteTask(id);
		return ResponseEntity.ok("Deleted task Successfully");
	}

	@DeleteMapping(value = "/task")
	public ResponseEntity<String> deleteAllTask() {
		taskManagerService.deleteAllTask();
		return ResponseEntity.ok("Deleted All Tasks Successfully");
	}
}
