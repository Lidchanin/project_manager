package com.lidchanin.pms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class Project is an entity.
 *
 * Annotation <code>@Entity</code> specify, that the class is an entity.
 *
 * Annotation <code>@Table</code> specified the primary table for the annotated table.
 * Parameter <code>name</code> specify on the table name.
 * Parameter <code>schema</code> specify on the schema name.
 */
@Entity
@Table(name = "projects", schema = "project_management_system")
public class Project implements Serializable {

    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    /**
     * One to many relationship
     * One project - many projectTasks
     */
    @JsonIgnore
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> projectTasks;

    /**
     * Many to many relationship
     * One projects - many developers
     * One developer - many projects
     */
    @JsonIgnore
    @ManyToMany(mappedBy = "projects")
    private List<User> users;

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
