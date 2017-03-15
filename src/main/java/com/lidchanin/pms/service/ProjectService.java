package com.lidchanin.pms.service;

/**
 * Interface <code>ProjectService</code> represents functions for working
 * with the database.
 */
public interface ProjectService {

    /**
     * Method <code>getAllProjectJSON</code> receive all project from the
     * database. And after receiving convert this to JSON String
     */
    String getAllProjectJSON();

}
