package com.lidchanin.pms.service;

import com.lidchanin.pms.repository.TaskLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskLogServiceImpl implements TaskLogService {
    @Autowired
    private TaskLogRepository taskLogRepository;
}
