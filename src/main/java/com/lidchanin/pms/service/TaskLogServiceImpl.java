package com.lidchanin.pms.service;

import com.lidchanin.pms.repository.TaskLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
