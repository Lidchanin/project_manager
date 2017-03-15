package com.lidchanin.pms.service;

import com.lidchanin.pms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
