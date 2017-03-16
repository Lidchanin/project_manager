package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.model.Task;
import com.lidchanin.pms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class <code>TaskServiceImpl</code> represents functions for working
 * with the database. And it's implements {@link TaskService} for
 * encapsulation.
 *
 * Annotation <code>Service</code> declaring that the class is a
 * service-component of the service-layer.
 * @see Service
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private JsonConverter jsonConverter = new JsonConverter();

    @Override
    public Task findTaskById(long id) {
        return taskRepository.findOne(id);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.delete(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public String getAllTasksJSON() {
        return jsonConverter.toJSON(taskRepository.findAll());
    }
}
