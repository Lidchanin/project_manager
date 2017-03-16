package com.lidchanin.pms.service;

import com.lidchanin.pms.model.Project;

import java.util.List;

/**
 * Interface <code>ProjectService</code> represents functions for working
 * with the database.
 */
public interface ProjectService {

    /**
     * Method <code>findProjectById</code> find project with needed id.
     * @param id unique identification for project.
     * @return project with required id.
     */
    Project findProjectById(long id);

    /**
     * Method <code>saveProject</code> save project in database.
     * @param project which need to save.
     */
    void saveProject(Project project);

    /**
     * Method <code>deleteProject</code> delete project in database.
     * @param project which need to delete.
     */
    void deleteProject(Project project);

    /**
     * Method <code>deleteProjectById</code> delete project with needed id in
     * database.
     * @param id unique identification of project.
     */
    void deleteProjectById(long id);

    /**
     * Method <code>getAllProjects</code> receive all projects from the database.
     * @see Project
     * @return all projects.
     */
    List<Project> getAlProjects();

    /**
     * Method <code>getAllProjectsJSON</code> receive all projects from
     * the database and convert them to JSON String format.
     * @return all projects in JSON String format.
     */
    String getAllProjectsJSON();
}
