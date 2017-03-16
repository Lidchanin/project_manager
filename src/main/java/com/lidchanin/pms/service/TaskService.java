package com.lidchanin.pms.service;

import com.lidchanin.pms.model.Task;

import java.util.List;

/**
 * Interface <code>TaskService</code> represents functions for working
 * with the database.
 */
public interface TaskService {
    /**
     * Method <code>findTaskById</code> find task with needed id.
     * @param id unique identification for task.
     * @return Task with required id.
     */
    Task findTaskById(long id);

    /**
     * Method <code>saveTask</code> save Task in database.
     * @param task which need to save.
     */
    void saveTask(Task task);

    /**
     * Method <code>deleteTask</code> delete Task in database.
     * @param task which need to delete.
     */
    void deleteTask(Task task);

    /**
     * Method <code>deleteTaskById</code> delete Task with needed id in
     * database.
     * @param id unique identification of Task.
     */
    void deleteTaskById(long id);

    /**
     * Method <code>getAllTasks</code> receive all tasks from the database.
     * @see Task
     * @return all tasks.
     */
    List<Task> getAllTasks();

    /**
     * Method <code>getAllTasksJSON</code> receive all tasks from
     * the database and convert them to JSON String format.
     * @return all tasks in JSON String format.
     */
    String getAllTasksJSON();
}
