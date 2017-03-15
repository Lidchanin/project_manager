package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    private JsonConverter jsonConverter = new JsonConverter();

    @Override
    public String getAllProjectJSON() {
        return jsonConverter.toJSON(projectRepository.findAll());
    }

}
