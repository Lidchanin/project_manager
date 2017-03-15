package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * Method <code>getAllProjectJSON</code> receive all project from the
     * database. And after receiving convert this to JSON String
     * @return all project in JSON String format.
     */
    @Override
    public String getAllProjectJSON() {
        return jsonConverter.toJSON(projectRepository.findAll());
    }

}
