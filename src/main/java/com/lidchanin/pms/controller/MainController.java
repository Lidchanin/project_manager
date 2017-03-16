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

/**
 * Class <code>MainController</code> is a main controller witch processed
 * HTTP-requests.
 *
 * Annotation <code>Controller</code> indicates that an annotated class is
 * a "Controller".
 * @see Controller
 *
 * Annotation <code>RequestMapping</code> for mapping web requests onto specific
 * handler classes and/or handler methods.
 * @see RequestMapping
 */
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

    /**
     * Method <code>getAllProjects</code> receives all project from the database with
     * using a <{@link ProjectService}.
     *
     * Annotation <code>RequestMapping</code> for mapping web requests onto specific
     * handler classes and/or handler methods.
     * @see RequestMapping
     *
     * Annotation <code>ResponseBody</code> shows that this method can return
     * a custom object in the form JSON.
     * @see ResponseBody
     *
     * @return all project in JSON String format.
     */
    @RequestMapping(value = {"/getAllProjects", "/getallprojects"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllProjects() {
        return projectService.getAllProjectsJSON();
    }

}