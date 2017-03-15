package com.lidchanin.pms.controller;

import com.lidchanin.pms.service.ProjectService;
import com.lidchanin.pms.service.TaskLogService;
import com.lidchanin.pms.service.TaskService;
import com.lidchanin.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/pms")
public class MainController {

    private final ProjectService projectService;
    private final TaskService taskService;
    private final TaskLogService taskLogService;
    private final UserService userService;

    @Autowired
    public MainController(ProjectService projectService, TaskService taskService, TaskLogService taskLogService, UserService userService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.taskLogService = taskLogService;
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllProjectsJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllProjectsJSON() {
        return projectService.getAllProjectJSON();
    }

}