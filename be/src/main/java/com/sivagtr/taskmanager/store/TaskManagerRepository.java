package com.sivagtr.taskmanager.store;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sivagtr.taskmanager.data.TaskManagerData;

public interface TaskManagerRepository extends MongoRepository<TaskManagerData, String> {
}
