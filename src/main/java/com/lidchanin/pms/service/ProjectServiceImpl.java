package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.model.Project;
import com.lidchanin.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class <code>ProjectServiceImpl</code> represents functions for working
 * with the database. And it's implements {@link ProjectService} for
 * encapsulation.
 *
 * Annotation <code>Service</code> declaring that the class is a
 * service-component of the service-layer.
 * @see Service
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private JsonConverter jsonConverter = new JsonConverter();

    @Override
    public Project findProjectById(long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepository.delete(id);
    }

    @Override
    public List<Project> getAlProjects() {
        return projectRepository.findAll();
    }

    @Override
    public String getAllProjectsJSON() {
        return jsonConverter.toJSON(projectRepository.findAll());
    }
}
