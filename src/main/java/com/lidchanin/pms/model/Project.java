package com.lidchanin.pms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class <code>Project</code> is an entity. <code>Project</code> implements
 * <code>Serializable</code> to support serialization.
 * @see Serializable
 *
 * Annotation <code>Entity</code> specify, that the class is an entity.
 * @see Entity
 *
 * Annotation <code>Table</code> specified the primary table for the annotated
 * table.
 * <code>name</code> matches the database table name.
 * <code>schema</code> matches the database schema, where located table.
 * @see Table
 */
@Entity
@Table(name = "projects", schema = "project_management_system")
public class Project implements Serializable {

    /**
     * Simple constructor for create empty project.
     */
    public Project() {
    }

    /**
     * Constructor for create project with name and description.
     * @param name is the name of the project.
     * @param description is the description of the project.
     */
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }


    /**
     * Field <code>id</code> adds a unique number to the object.
     *
     * Annotation <code>Id</code> Specifies the primary key of an entity.
     * @see Id
     *
     * Annotation <code>GeneratedValue</code> provides for the specification
     * of generation strategies for the values of primary keys.
     * <code>strategy</code> specify, how the field <code>id</code> will be filled.
     * @see GeneratedValue
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    /**
     * Field <code>name</code> is the name of the object <code>Project</code>.
     * <code>nullable = false</code> specify, that the name can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Field <code>name</code> is the description of the object <code>Project</code>.
     *
     * Annotation <code>Column</code> specifies the mapped column for a persistent
     * property or field.
     * @see Column
     */
    @Column(name = "description")
    private String description;

    /**
     * Filed <code>projectTasks</code> contains an all tasks tied to this project.
     *
     * Annotation <code>OneToMany</code> need for specify a relationship.
     * @see OneToMany
     *
     * One to many relationship:
     * One project - many project tasks.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> projectTasks;

    /**
     * Field <code>users</code> contains an all developers tied to this project.
     *
     * Annotation <code>OneToMany</code> need for specify a relationship.
     *
     * Many to many relationship:
     * One projects - many developers,
     * One developer - many projects.
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<User> users;

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<Task> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
