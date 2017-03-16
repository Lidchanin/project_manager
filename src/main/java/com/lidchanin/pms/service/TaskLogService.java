package com.lidchanin.pms.service;

import com.lidchanin.pms.model.TaskLog;

import java.util.List;

/**
 * Interface <code>TaskLogService</code> represents functions for working
 * with the database.
 */
public interface TaskLogService {
    /**
     * Method <code>findTaskLogById</code> find task log with needed id.
     * @param id unique identification for task log.
     * @return Task log with required id.
     */
    TaskLog findTaskLogById(long id);

    /**
     * Method <code>saveTaskLog</code> save task log in database.
     * @param taskLog which need to save.
     */
    void saveTaskLog(TaskLog taskLog);

    /**
     * Method <code>deleteTaskLog</code> delete task log in database.
     * @param taskLog which need to delete.
     */
    void deleteTaskLog(TaskLog taskLog);

    /**
     * Method <code>deleteTaskLogById</code> delete task log with needed id in
     * database.
     * @param id unique identification of task log.
     */
    void deleteTaskLogById(long id);

    /**
     * Method <code>getAllTaskLogs</code> receive all task logs from the database.
     * @see TaskLog
     * @return all task logs.
     */
    List<TaskLog> getAllTaskLogs();

    /**
     * Method <code>getAllTaskLogsJSON</code> receive all task logs from
     * the database and convert them to JSON String format.
     * @return all task logs in JSON String format.
     */
    String getAllTaskLogsJSON();
}
