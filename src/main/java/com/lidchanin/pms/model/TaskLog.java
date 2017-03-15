package com.lidchanin.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class <code>TaskLog</code> is an entity. <code>TaskLog</code> implements
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
@Table(name = "task_logs", schema = "project_management_system")
public class TaskLog implements Serializable {

    /**
     * Simple constructor for create empty TaskLog.
     */
    public TaskLog() {
    }

    /**
     * Constructor for create task log with description
     * @param description is the description of the task log
     */
    public TaskLog(String description) {
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

    // todo: Need to receiving time from the client
    /**
     * Field <code>time</code> is the time spent on the task of the object <code>TaskLog</code>.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "time")
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    /**
     * Field <code>description</code> is the description of the object <code>Project</code>.
     * <code>nullable = false</code> specify, that the description can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Field <code>user</code> contains a developer tied to this task.
     *
     * Annotation <code>ManyToOne</code> need for specify a relationship.
     * @see ManyToOne
     *
     * Annotation <code>JoinColumn</code> specifies a column for joining an entity
     * association.
     * @see JoinColumn
     *
     * Many to one relationship
     * Many task logs - one developer
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    private User user;

    /**
     * Filed <code>task</code> contains a task tied to this task log.
     *
     * Annotation <code>OneToOne</code> need for specify a relationship.
     * @see OneToOne
     *
     * One to one relationship
     * One task log - one task
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "taskLog")
    private Task task;

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}