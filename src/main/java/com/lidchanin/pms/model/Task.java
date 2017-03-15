package com.lidchanin.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class <code>Task</code> is an entity.<code>Task</code> implements
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
@Table(name = "tasks")
public class Task implements Serializable {

    /**
     * Simple constructor for create empty task.
     */
    public Task() {
    }

    /**
     * Constructor for create task with name, description, status.
     * @param name is the name of the task
     * @param description is the description on the task
     * @param status is the status on the task(started, in develop, finish,...)
     */
    public Task(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
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
     * Field <code>name</code> is the name of the object <code>Task</code>.
     * <code>nullable = false</code> specify, that the name can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Field <code>description</code> is the name of the object <code>Task</code>.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "description")
    private String description;

    /**
     * Field <code>status</code> is the name of the object <code>Task</code>.
     * <code>nullable = false</code> specify, that the name can't be empty
     * <code>unique = true</code> specify, that the column is a unique key.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "status", nullable = false, unique = true, length = 15)
    private String status;

    // todo: Need to receiving time from the client
    /**
     * Field <code>startTime</code> is the name of the object <code>Task</code>.
     * Shows where task is started.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "start_time")
    private Timestamp startTime = new Timestamp(System.currentTimeMillis());

    /**
     * Field <code>finalTime</code> is the final time of the object <code>Task</code>.
     * Shows where task is finished.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "final_time")
    private Timestamp finalTime;

    /**
     * Field <code>readiness</code> is the readiness of the object <code>Task</code>.
     * Shows where task is readiness or not.
     * <code>nullable = false</code> specify, that the name can't be empty
     * <code>columnDefinition = "boolean default false"</code> sets the value to
     * <code>false</code> by the default
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    // todo: check, work default value or not
    @Column(name = "readiness", nullable = false, columnDefinition = "boolean default false")
    private boolean readiness;

    /**
     * Filed <code>project</code> contains an project tied to this task.
     *
     * Annotation <code>ManyToOne</code> need for specify a relationship.
     * @see ManyToOne
     * Annotation <code>JoinColumn</code> specifies a column for joining an entity
     * association.
     * @see JoinColumn
     *
     * Many to one relationship:
     * Many tasks - one project.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    /**
     * Filed <code>user</code> contains an project tied to this task.
     *
     * Annotation <code>ManyToOne</code> need for specify a relationship.
     * @see ManyToOne
     * Annotation <code>JoinColumn</code> specifies a column for joining an entity
     * association.
     * @see JoinColumn
     *
     * Many to one relationship
     * Many tasks - one user
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    private User user;

    /**
     * Filed <code>taskLog</code> contains an project tied to this task.
     *
     * Annotation <code>OneToOne</code> need for specify a relationship.
     * @see OneToOne
     * Annotation <code>JoinColumn</code> specifies a column for joining an entity
     * association.
     * @see JoinColumn
     *
     * One to one relationship
     * One task - one task log
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_log_id")
    private TaskLog taskLog;

    // getters and setters

    public boolean isReadiness() {
        return readiness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Timestamp finalTime) {
        this.finalTime = finalTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskLog getTaskLog() {
        return taskLog;
    }

    public void setTaskLog(TaskLog taskLog) {
        this.taskLog = taskLog;
    }
}
