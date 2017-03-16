package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.model.TaskLog;
import com.lidchanin.pms.repository.TaskLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class <code>TaskLogServiceImpl</code> represents functions for working
 * with the database. And it's implements {@link TaskLogService} for
 * encapsulation.
 *
 * Annotation <code>Service</code> declaring that the class is a
 * service-component of the service-layer.
 * @see Service
 */
@Service
public class TaskLogServiceImpl implements TaskLogService {

    @Autowired
    private TaskLogRepository taskLogRepository;

    JsonConverter jsonConverter = new JsonConverter();

    @Override
    public TaskLog findTaskLogById(long id) {
        return taskLogRepository.findOne(id);
    }

    @Override
    public void saveTaskLog(TaskLog taskLog) {
        taskLogRepository.save(taskLog);
    }

    @Override
    public void deleteTaskLog(TaskLog taskLog) {
        taskLogRepository.delete(taskLog);
    }

    @Override
    public void deleteTaskLogById(long id) {
        taskLogRepository.delete(id);
    }

    @Override
    public List<TaskLog> getAllTaskLogs() {
        return taskLogRepository.findAll();
    }

    @Override
    public String getAllTaskLogsJSON() {
        return jsonConverter.toJSON(taskLogRepository.findAll());
    }
}
